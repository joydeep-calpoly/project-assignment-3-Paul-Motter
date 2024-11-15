package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserParseVisitor extends ParserVisitor{

    public ParserParseVisitor(String loggerFilePath) throws SecurityException, IOException{
        super(loggerFilePath);
    }

    @Override
    ArrayList<ArticleSimple> visit(ArticleCreatorSimple acs) throws IOException {
        //get String of content to parse.
        String content = acs.s.accept(new SourceStringVisitor()); 
        
        //Parse the String.
        ObjectMapper mapper = new ObjectMapper();
        //creates an ArrayList<ArticleSimple> so that the remove
        ArrayList<ArticleSimple> articleList = new ArrayList<>();
        articleList.add(mapper.readValue(content, ArticleSimple.class));
        
        //Remove Article if it is a bad article.
        if (articleList.get(0).getTitle() == null || articleList.get(0).getDescription() == null || articleList.get(0).getPublishedAt() == null || articleList.get(0).getURL() == null)
            articleList.remove(0);

        //return the ArrayList which will be empty if the article was bad.
        return articleList;
    }

    @Override
    ArrayList<Article> visit(ArticleCreatorNewsAPI scn) throws IOException {
        //Get String of content to parse.
        String content = scn.s.accept(new SourceStringVisitor());

        //Parse the String.
        ObjectMapper mapper = new ObjectMapper();
        //Parse the article input String with mapper.
        ArrayList<Article> articles = mapper.readValue(content, ArticleListNewsAPI.class).getArticleList(); 

        //Remove any bad articles.
        for(int i=0; i<articles.size(); i++){
            //checks each relavent variable for null values and removes such articles.
            if (articles.get(i).getTitle() == null || articles.get(i).getDescription() == null || articles.get(i).getPublishedAt() == null || articles.get(i).getURL() == null){
                articles.remove(i);
                i--;
                super.log.warning("ArticleNewsAPI removed due to incomplete information.");
            }
        }

        //Return the ArrayList of articles with all bad articles removed.
        return articles;
    }
    
}
