package ArticleParser;

import java.io.IOException;
import java.net.URL;

public class SourceURL implements SourceClass{

    private URL url;
    
    /**
     * Constructor to set the URL to the provided url.
     * @param url The url the user would like to use as a source.
     */
    public SourceURL(URL url){
        this.url = url;
    }

    @Override
    public String accept(SourceVisitor sv) throws IOException {
        return sv.visit(url);
    }
    
}
