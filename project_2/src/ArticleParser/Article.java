package ArticleParser;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

    class Article {

        private Source source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private Date publishedAt;
        private String content;
        
        /**
         * Private constructor for jackson parsing.
         * @param source
         * @param author
         * @param title
         * @param description
         * @param url
         * @param urlToImage
         * @param publishedAt
         * @param content
         */
        @JsonCreator
        private Article(@JsonProperty("source") Source source, @JsonProperty("author") String author,
                        @JsonProperty("title") String title, @JsonProperty("description") String description,
                        @JsonProperty("url") String url, @JsonProperty("urlToImage") String urlToImage,
                        @JsonProperty("publishedAt") Date publishedAt, @JsonProperty("content") String content){
            this.source = source;
            this.author = author;
            this.title = title;
            this.description = description;
            this.url = url;
            this.urlToImage = urlToImage;
            this.publishedAt = publishedAt;
            this.content = content;
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

        /*
         * Nested class of Article.
         */
        private static class Source {

            private String id;
            private String name;
        
            /**
             * Private constructor for Jsckson parsing.
             * @param id
             * @param name
             */
            @JsonCreator
            private Source(@JsonProperty("id") String id, @JsonProperty("name") String name){
                this.id = id;
                this.name = name;
            }
        
        }
    }