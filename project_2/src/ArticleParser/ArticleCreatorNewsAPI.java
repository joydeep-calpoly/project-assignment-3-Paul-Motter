package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;

public class ArticleCreatorNewsAPI extends ArticleCreator{

    /**
     * Calls the super constructor and passes the SourceClass.
     * @param s SourceClass to be passed to the super constructor. 
     */
    ArticleCreatorNewsAPI(SourceClass s){
        super(s);
    }

    @Override
    ArrayList<Article> accept(ParserVisitor pv) throws IOException {
        return pv.visit(this);
    }
    
}
