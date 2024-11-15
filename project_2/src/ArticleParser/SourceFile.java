package ArticleParser;

import java.io.File;
import java.io.IOException;

public class SourceFile implements SourceClass{
    private File f;

    public SourceFile(File f){
        this.f = f;
    }

    //get rid
    @Override
    public String accept(SourceVisitor sv) throws IOException {
       return sv.visit(f);
    }
    
}
