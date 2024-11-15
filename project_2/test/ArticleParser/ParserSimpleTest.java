package ArticleParser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

public class ParserSimpleTest {
    
    /**
     * Tests a good ArticleSimple where all content is present.
     * @throws SecurityException
     * @throws IOException
     */
    @Test
    public void parserSimpleGoodTest() throws SecurityException, IOException{
        ParserParseVisitor PS = new ParserParseVisitor("ParserSimpleTestLoggs/parserSimpleGoodTest.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs2/simple.json")), StandardCharsets.UTF_8);
        
        ArticleSimple result = PS.parseSimple(input).get(0);

        assertEquals("""
            Article
            Title: Assignment #2
            Description: Extend Assignment #1 to support multiple sources and to introduce source processor.
            Publication Date: 2021-04-16
            URL: https://canvas.calpoly.edu/courses/55411/assignments/274503\n""",
            result.toString());
    }

    /**
     * Tests a bad ArticleSimple where the description is null.
     * @throws SecurityException
     * @throws IOException
     */
    @Test
    public void parserSimpleBadTest1() throws SecurityException, IOException{
        ParserParseVisitor PS = new ParserParseVisitor("ParserSimpleTestLoggs/parserSimpleBadTest1.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs2/simpleBad1.json")), StandardCharsets.UTF_8);
        
        ArrayList<ArticleSimple> result = PS.parseSimple(input);
        ArrayList<ArticleSimple> expected = new ArrayList<>();
        assertEquals(expected.size(), result.size());
    }

    /**
     * Tests a bad ArticleSimple where the publishedAt is missing.
     * @throws SecurityException
     * @throws IOException
     */
    @Test
    public void parserSimpleBadTest2() throws SecurityException, IOException{
        ParserParseVisitor PS = new ParserParseVisitor("ParserSimpleTestLoggs/parserSimpleBadTest2.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs2/simpleBad2.json")), StandardCharsets.UTF_8);
        
        ArrayList<ArticleSimple> result = PS.parseSimple(input);
        ArrayList<ArticleSimple> expected = new ArrayList<>();
        assertEquals(expected.size(), result.size());
    }

    /**
     * Tests a bad ArticleSimple where the title is null.
     * @throws SecurityException
     * @throws IOException
     */
    @Test
    public void parserSimpleBadTest3() throws SecurityException, IOException{
        ParserParseVisitor PS = new ParserParseVisitor("ParserSimpleTestLoggs/parserSimpleBadTest3.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs2/simpleBad3.json")), StandardCharsets.UTF_8);
        
        ArrayList<ArticleSimple> result = PS.parseSimple(input);
        ArrayList<ArticleSimple> expected = new ArrayList<>();
        assertEquals(expected.size(), result.size());
    }

    /**
     * Tests a bad ArticleSimple where the url is null.
     * @throws SecurityException
     * @throws IOException
     */
    @Test
    public void parserSimpleBadTest4() throws SecurityException, IOException{
        ParserParseVisitor PS = new ParserParseVisitor("ParserSimpleTestLoggs/parserSimpleBadTest4.txt");
        
        String input = new String(Files.readAllBytes(Paths.get("inputs2/simpleBad4.json")), StandardCharsets.UTF_8);
        
        ArrayList<ArticleSimple> result = PS.parseSimple(input);
        ArrayList<ArticleSimple> expected = new ArrayList<>();
        assertEquals(expected.size(), result.size());
    }
}
