package ArticleParser;

import java.io.File;
import java.io.IOException;

public class SourceFile implements SourceClass{
    private File f;

    /**
     * Constructor to set the file f.
     * @param f The file the user would like to use as a Source.
     */
    SourceFile(File f){
        this.f = f;
    }

    @Override
    public String accept(SourceVisitor sv) throws IOException {
       return sv.visit(f);
    }
    
}
