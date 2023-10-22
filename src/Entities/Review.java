package Entities;

public class Review {
    private String stars;
    private String comment;
    private String date;
    private Client client;
    private Articles article;

    public Review(String stars, String comment, String date, Client client, Articles article) {
        this.stars = stars;
        this.comment = comment;
        this.date = date;
        this.client = client;
        this.article = article;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }
}
