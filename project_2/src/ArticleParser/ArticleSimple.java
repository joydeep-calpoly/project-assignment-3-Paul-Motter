package ArticleParser;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

class ArticleSimple{
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Date publishedAt;
    private String title;
    private String url;

    /**
     * Private constructor for Jackson parsing of JSON formats.
     * @param description
     * @param publishedAt
     * @param title
     * @param url
     */
    @JsonCreator
    private ArticleSimple(@JsonProperty("description") String description,
                          @JsonProperty ("publishedAt") Date publishedAt,
                          @JsonProperty("title") String title,
                          @JsonProperty("url") String url){
    this.description = description;
    this.publishedAt = publishedAt;
    this.title = title;
    this.url = url;
    }

    /**
     * @return the String title of the article.
     */
    String getTitle(){
        return title;
    }
    
    /**
     * @return the String description of the article.
     */
    String getDescription(){
        return description;
    }

    /**
     * @return the String date of publication of the article.
     */
    Date getPublishedAt(){
        return publishedAt == null ? null : (Date) publishedAt.clone();
    }
    
    /**
     * @return the String url of the article.
     */
    String getURL(){
        return url;
    }

    /**
     * Gives a string representation of the article with the Title, Description, Publication Date, and URL.
     * @return a string representation of the class contents.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Article\nTitle: ");
        sb.append(title);
        sb.append("\nDescription: ");
        sb.append(description);
        sb.append("\nPublication Date: ");
        sb.append(publishedAt);
        sb.append("\nURL: ");
        sb.append(url);
        sb.append("\n");
        return sb.toString();
    }



}