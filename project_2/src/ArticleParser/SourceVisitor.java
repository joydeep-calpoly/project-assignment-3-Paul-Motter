package ArticleParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface SourceVisitor {

    /**
     * A method for returning the contents of f as a String.
     * @param f The file to be read.
     * @return The String returned.
     * @throws IOException
     */
    String visit(File f) throws IOException;

    /**
     * A method for returning the contents of url as a String.
     * @param url The url to be read.
     * @return The String Returned.
     * @throws IOException
     */
    String visit(URL url) throws IOException;
    
}
