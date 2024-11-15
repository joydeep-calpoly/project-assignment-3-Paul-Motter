package ArticleParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

class SourceStringVisitor implements SourceVisitor {

    /**
     * Returns a string of a JSON that can be parsed into Articles. Gotten from a URL that is url.
     * @param url Is the url of a NewsAPI endpoint.
     * @param APIKey Is the key needed at the end of a NewsAPI endpoint.
     * @return String representation of the JSON containing articles.
     * @throws IOException
     */
    @Override
    public String visit(URL url) throws IOException {
        //Read From URL
        return new String(url.openStream().readAllBytes(), StandardCharsets.UTF_8);
    }

    

    /**
     * Returns a string of a JSON that can be parsed into Articles. Gotten from a .json file at filePath.
     * @param filePath is the filepath of the JSON file to read.
     * @return String representation of the JSON containing articles.
     * @throws IOException
     */
    @Override
     public String visit(File f) throws IOException{
        //Read file into utf-8
        return new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
        //return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8); 
    }
}
