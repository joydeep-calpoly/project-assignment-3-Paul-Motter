package ArticleParser;

import java.io.IOException;

public interface SourceClass {

    /**
     * Accepts a SourceVisitor to call visit().
     * @param sv Most commonly a SourceStringVisitor whose visit() returns a String representation of the source.
     * @return In the case of SourceStringVisitors it  returns a String representation of the source.
     * @throws IOException
     */
    String accept(SourceVisitor sv) throws IOException;

}
