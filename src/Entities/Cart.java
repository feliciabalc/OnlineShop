package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cart {
    private int id;
    private double quantity;
    private Client client;
    private List<Articles> articles= new ArrayList<>();

    private List<ClientCartObserver> observers = new ArrayList<>();

    public List<ClientCartObserver> getObservers(Cart cart) {
        return cart.observers;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client newClient) {
        this.client = newClient;
    }


    public Cart(int id, double quantity) {
        this.id = id;
        this.quantity = quantity;

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


    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }



    public void addArticles(Articles article){
        articles.add(article);
    }

    public void removeArticles(Articles article){
        articles.remove(article);
    }



    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", client=" + client +
                '}';
    }

    public void addObserver(ClientCartObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ClientCartObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(CartObserver obs: observers)
            obs.update(this);
    }


}
