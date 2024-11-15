package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;

public class ArticleCreatorNewsAPI extends ArticleCreator{

    public ArticleCreatorNewsAPI(SourceClass s){
        super(s);
    }

    @Override
    ArrayList<Article> accept(ParserVisitor pv) throws IOException {
        return pv.visit(this);
    }
    
}
