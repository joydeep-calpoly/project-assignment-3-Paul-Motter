package ArticleParser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

public class ParserNewsAPItest {

    /**
     * Tests parseArticle with a good file containing 20 complete articles.
     * @throws IOException 
     * @throws SecurityException 
     */
    @Test
    public void parsingGoodTest() throws SecurityException, IOException {

        ParserNewsAPIVisitor parserNAPI = new ParserNewsAPIVisitor("ParserNewsAPItestLoggs/LoggerParsingGoodTest.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs1/customGood.json")), StandardCharsets.UTF_8);
        
        ArrayList<Article> result = parserNAPI.parseArticle(input);

        assertEquals(result.size(), 20);

    }

    /**
     * Tests parseArticles with a bad file containing only 8 incomplete articles and will return an empty list. 
     * @throws IOException 
     * @throws SecurityException 
     */
    @Test
    public void parsingBadTest() throws SecurityException, IOException {
    
        ParserNewsAPIVisitor parserNAPI = new ParserNewsAPIVisitor("ParserNewsAPItestLoggs/LoggerParsingBadTest.txt");
    
        String input = new String(Files.readAllBytes(Paths.get("inputs1/customBad.json")), StandardCharsets.UTF_8);

        ArrayList<Article> result = parserNAPI.parseArticle(input);

        assertEquals(0, result.size());
    }

    /**
     * Tests parseArticles with a file containing 1 bad and then 2 good articles.
     * @throws IOException 
     * @throws SecurityException 
     */
    @Test
    public void parsingMixedGoodBad1Test() throws SecurityException, IOException {

        ParserNewsAPIVisitor parserNAPI = new ParserNewsAPIVisitor("ParserNewsAPItestLoggs/LoggerParsingGoodBad1Test.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs1/customGoodBad1.json")), StandardCharsets.UTF_8);
        
        ArrayList<Article> result = parserNAPI.parseArticle(input);

        //Build resultant array of articles into one string representation.
        StringBuilder stringResult = new StringBuilder();
        for (Article r: result){
            stringResult.append(r);
        }
        assertEquals("Article\n" +
                     "Title: It’s been 20 years since the launch of Mac OS X - Ars Technica\n" + 
                     "Description: It's macOS 11 now, but the DNA is the same.\n" + 
                     "Publication Date: Wed Mar 24 14:44:01 PDT 2021\n" + 
                     "URL: https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/\n" + 
                     "Article\n" + 
                     "Title: NASA helicopter took a piece of the Wright brothers' plane to Mars - CNET\n" + 
                     "Description: NASA is gearing up for a dramatic Mars test flight of Ingenuity as soon as April 8.\n" +
                     "Publication Date: Wed Mar 24 14:43:00 PDT 2021\n" + 
                     "URL: https://www.cnet.com/news/nasa-helicopter-took-a-piece-of-the-wright-brothers-famous-plane-to-mars/\n",
                     stringResult.toString());
    }

    /**
     * Tests parseArticles with a file containing 1 good, 1 bad, and then 1 good article.
     * @throws IOException 
     * @throws SecurityException 
     */
    @Test
    public void parsingMixedGoodBad2Test() throws SecurityException, IOException {

        ParserNewsAPIVisitor parserNAPI = new ParserNewsAPIVisitor("ParserNewsAPItestLoggs/LoggerParsingMixedGoodBad2Test.txt");

        String input = new String(Files.readAllBytes(Paths.get("inputs1/customGoodBad2.json")), StandardCharsets.UTF_8);
        
        ArrayList<Article> result = parserNAPI.parseArticle(input);
        
        //Build resultant array of articles into one string representation.
        StringBuilder stringResult = new StringBuilder();
        for (Article r: result){
            stringResult.append(r);
        }

        assertEquals("Article\n" +
                     "Title: It’s been 20 years since the launch of Mac OS X - Ars Technica\n" + 
                     "Description: It's macOS 11 now, but the DNA is the same.\n" + 
                     "Publication Date: Wed Mar 24 14:44:01 PDT 2021\n" + 
                     "URL: https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/\n" + 
                     "Article\n" + 
                     "Title: NASA helicopter took a piece of the Wright brothers' plane to Mars - CNET\n" + 
                     "Description: NASA is gearing up for a dramatic Mars test flight of Ingenuity as soon as April 8.\n" +
                     "Publication Date: Wed Mar 24 14:43:00 PDT 2021\n" + 
                     "URL: https://www.cnet.com/news/nasa-helicopter-took-a-piece-of-the-wright-brothers-famous-plane-to-mars/\n",
                     stringResult.toString());
    }

    /**
     * Tests parseArticles with a file containing 2 good and then 1 bad article.
     * @throws IOException 
     * @throws SecurityException 
     */
    @Test
    public void parsingMixedGoodBad3Test() throws SecurityException, IOException {

        ParserNewsAPIVisitor parserNAPI = new ParserNewsAPIVisitor("ParserNewsAPItestLoggs/LoggerParsingMixedGoodBad3Test.txt");

        String input = new String(Files.readAllBytes(Paths.get("inputs1/customGoodBad3.json")), StandardCharsets.UTF_8);
    
        ArrayList<Article> result = parserNAPI.parseArticle(input);

         //Build resultant array of articles into one string representation.
        StringBuilder stringResult = new StringBuilder();
        for (Article r: result){
            stringResult.append(r);
        }

        assertEquals("Article\n" +
                     "Title: It’s been 20 years since the launch of Mac OS X - Ars Technica\n" + 
                     "Description: It's macOS 11 now, but the DNA is the same.\n" + 
                     "Publication Date: Wed Mar 24 14:44:01 PDT 2021\n" + 
                     "URL: https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/\n" + 
                     "Article\n" + 
                     "Title: NASA helicopter took a piece of the Wright brothers' plane to Mars - CNET\n" + 
                     "Description: NASA is gearing up for a dramatic Mars test flight of Ingenuity as soon as April 8.\n" +
                     "Publication Date: Wed Mar 24 14:43:00 PDT 2021\n" + 
                     "URL: https://www.cnet.com/news/nasa-helicopter-took-a-piece-of-the-wright-brothers-famous-plane-to-mars/\n", 
                     stringResult.toString()); 
                        
    }
}

