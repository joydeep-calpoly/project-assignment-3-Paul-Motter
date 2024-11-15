package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;

public class ArticleCreatorSimple extends ArticleCreator{

    /**
     * Calls the super constructor and passes the SourceClass.
     * @param s SourceClass to be passed to the super constructor. 
     */
    ArticleCreatorSimple(SourceClass s){
        super(s);
    }

    @Override
    ArrayList<ArticleSimple> accept(ParserVisitor pv) throws IOException {
        return pv.visit(this);
    }

}
