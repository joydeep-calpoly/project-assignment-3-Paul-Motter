package ArticleParser;

import java.io.IOException;

//get rid
public interface SourceClass {
    public String accept(SourceVisitor sv) throws IOException;
}
