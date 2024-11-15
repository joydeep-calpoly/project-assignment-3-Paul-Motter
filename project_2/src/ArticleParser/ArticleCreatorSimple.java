package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;

public class ArticleCreatorSimple extends ArticleCreator{

    public ArticleCreatorSimple(SourceClass s){
        super(s);
    }

    @Override
    ArrayList<ArticleSimple> accept(ParserVisitor pv) throws IOException {
        return pv.visit(this);
    }

}
