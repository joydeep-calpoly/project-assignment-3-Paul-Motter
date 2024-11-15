package ArticleParser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class ArticleCreatorTest {
    
    
    @Test
    public void ArticleCreatorSimpleFromFileTest() throws SecurityException, IOException{
        //configure a parser for a Simple article from the file "inputs2/simple.json".
        ArticleCreator ac = new ArticleCreatorSimple(new SourceFile(new File("inputs2/simple.json")));
        //using the creator to parse using a parse visitor.
        ArticleSimple result = ((ArrayList<ArticleSimple>)ac.accept(new ParserParseVisitor("ArticleCreatorTestLoggs/ArticleCreatorSimpleFromFileTest"))).get(0);
        
        assertEquals("""
            Article
            Title: Assignment #2
            Description: Extend Assignment #1 to support multiple sources and to introduce source processor.
            Publication Date: 2021-04-16
            URL: https://canvas.calpoly.edu/courses/55411/assignments/274503\n""",
            result.toString());
    }

    @Test
    public void ArticleCreatorNewsAPIFromFileTest() throws SecurityException, IOException{
        //configure a parser for a NewsAPI article from the file "inputs2/newsapi.json".
        ArticleCreator ac = new ArticleCreatorNewsAPI(new SourceFile(new File("inputs3/easyNewsAPI.json")));
        //using the creator to parse using a parse visitor.
        Article result = ((ArrayList<Article>)ac.accept(new ParserParseVisitor("ArticleCreatorTestLoggs/ArticleCreatorSimpleFromFileTest"))).get(0);
        
        assertEquals("""
            Article
            Title: The latest on the coronavirus pandemic and vaccines: Live updates - CNN
            Description: The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.
            Publication Date: Wed Mar 24 15:32:00 PDT 2021
            URL: https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html
            """,
            result.toString());
    }
}
