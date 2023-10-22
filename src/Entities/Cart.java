package Entities;

public class Cart {
    private double quantity;
    private Client client;
    private Articles[] articles;

    public Cart(double quantity, Client client, Articles[] articles) {
        this.quantity = quantity;
        this.client = client;
        this.articles = articles;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }
}
