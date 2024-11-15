package ArticleParser;

import java.io.IOException;

public abstract class ArticleCreator{

    SourceClass s;

    /**
     * Saves a SourceClass that can be used to convert a source into a string.
     * @param s
     */
    ArticleCreator(SourceClass s){
        this.s = s;
    }

    /**
     * Used to accept and call visit on a ParserVisitor.
     * Most common visitor is ParserParseVisitor that will get a String from SourceClass s and parse it.
     * @param <T> The returning parsed object.
     * @param pv The ParserVisitor that will determin which parser to use.
     * @return Typically an ArrayList<Article> or ArrayList<ArticleSimple>
     * @throws IOException Inherited from getting a String from SourceClass.
     */
    abstract <T> T accept(ParserVisitor pv) throws IOException;
}
