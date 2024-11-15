package ArticleParser;

import java.io.IOException;
import java.net.URL;

public class SourceURL implements SourceClass{
    private URL url;
    
    public SourceURL(URL url){
        this.url = url;
    }

    @Override
    public String accept(SourceVisitor sv) throws IOException {
        return sv.visit(url);
    }
    
}
