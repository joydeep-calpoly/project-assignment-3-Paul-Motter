package ArticleParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Demo {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        //-----New Demo Flow-----
        Scanner keyboard = new Scanner(System.in);
        boolean continueParsing = true;
        do{
            
            //Get an input Type
            System.out.println("Select a input type to parse. Any other inputs will exit.\n[1] File\n[2] URL");
            SourceClass sc = null;
            switch (keyboard.nextLine()) {
                case "1":
                    System.out.println("Enter a filepath:");
                    sc = new SourceFile(new File(keyboard.nextLine()));
                    break;
                case "2":
                    System.out.println("Enter a URL");
                    sc = new SourceURL(new URL(keyboard.nextLine()));
                    break;
                default:
                    continueParsing = false;
                    break;
            }
            
            if (!continueParsing) break;

            //Get an ArticleType and parse it.
            System.out.println("Select an article type to parse. Any other inputs will exit.\n[1] NewsAPI\n[2] SimpleArticle");
            Object articleList = null;
            switch (keyboard.nextLine()) {
                case "1":
                    ArticleCreatorNewsAPI acn = new ArticleCreatorNewsAPI(sc);    
                    articleList = acn.accept(new ParserParseVisitor("NewsAPI_Articles"));
                    break;
                case "2":
                    ArticleCreatorSimple acs = new ArticleCreatorSimple(sc);
                    articleList = acs.accept(new ParserParseVisitor("Simple_Articles"));
                    break;
                default:
                    continueParsing = false;
                    break;
            }

            //print the list of articles.
            if (articleList instanceof ArrayList<?>){
                for (Object article: (ArrayList<?>) articleList){
                    System.out.println(article);
                }
            }
        } while (continueParsing);    
    }
    
}
