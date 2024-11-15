package ArticleParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface SourceVisitor {
    String visit(File f) throws IOException;
    String visit(URL url) throws IOException;

    
}
