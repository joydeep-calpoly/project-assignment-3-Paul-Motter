package ArticleParser;

import java.io.IOException;

public abstract class ArticleCreator{
    SourceClass s;

    public ArticleCreator(SourceClass s){
        this.s = s;
    }

    abstract <T> T accept(ParserVisitor pv) throws IOException;
}
