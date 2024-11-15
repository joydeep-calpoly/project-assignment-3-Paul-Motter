package ArticleParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

abstract class ParserVisitor{

    //Logger for tracking all removed articles.
    Logger log;

    /**
     * Initializes the logger for the instance of the class.
     * @param loggerFilePath Is the filepath for the logger to stored all logs.
     * @throws SecurityException
     * @throws IOException
     */
    ParserVisitor(String loggerFilePath) throws SecurityException, IOException{
        this.log = Logger.getLogger("ArticleParser"); //creates new logger
        FileHandler fh = new FileHandler(loggerFilePath, false);
        fh.setFormatter(new SimpleFormatter()); //Adds a formatter to only print minimal details and print warning message.
        this.log.addHandler(fh);//Sets an output for the logger to the .txt file and sets append to false.
        this.log.setUseParentHandlers(false); //disables the parentHandler that atuomatically logs.
    }
    
     /**
      * Is a method for creating an ArticleSimple from an ArticleCreatorSimple.
      * @param acs Defines the article to be parsed.
      * @return Returns an array with 1 or 0 ArticleSimple depending on if the article is bad and removed.
      * @throws IOException
      */
    abstract ArrayList<ArticleSimple> visit(ArticleCreatorSimple acs) throws IOException;

    /**
     * Is a method for creating an ArrayList<Article> from an ArticleCreatorNewsAPI.
     * @param acn Object containing information on the article to be parsed.
     * @return Returns a list of articles where bad articles are removed.
     * @throws IOException
     */
    abstract ArrayList<Article> visit(ArticleCreatorNewsAPI scn) throws IOException;




    
}
