package ArticleParser;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class ArticleListNewsAPI{

    
    private String status;
    private int totalResults;
    private ArrayList<Article> articleList;

    /**
     * Private constructor for Jackson parsing.
     * @param status 
     * @param totalResults number of total results reported by the JSON
     * @param articleList An ArrayList of aticles.
     */
    @JsonCreator
    private ArticleListNewsAPI(@JsonProperty("status") String status, @JsonProperty("totalResults") int totalResults, @JsonProperty("articles") ArrayList<Article> articleList){
    this.status = status;
    this.totalResults = totalResults;
    this.articleList = articleList;
    }

    /**
     * gets the list of articles from a parsed json file.
     * @return A clone of Arraylist<Articles> that contains every article directly from the json unfiltered and unsorted. 
     */
    ArrayList<Article> getArticleList(){
        return (ArrayList<Article>) articleList.clone();
    }
}

