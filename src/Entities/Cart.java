package Entities;

import java.util.Arrays;

public class Cart {
    private int id;
    private double quantity;
    private Client client;
    private Articles[] articles;

    public Cart(int id,double quantity, Client client, Articles[] articles) {
        this.id = id;
        this.quantity = quantity;
        this.client = client;
        this.articles = articles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", client=" + client +
                ", articles=" + Arrays.toString(articles) +
                '}';
    }
}
