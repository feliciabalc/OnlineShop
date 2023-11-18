package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client{
    private int id;
    private  String  name;
    private String  address;
    private double telefon;
    private List<Orders> orders= new ArrayList<>();
    private Cart cart;
    private List<Review> reviews= new ArrayList();

    public Client(int id,String name, String address, double telefon) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTelefon() {
        return telefon;
    }

    public void setTelefon(double telefon) {
        this.telefon = telefon;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }



    public List<Review> getReview() {
        return reviews;
    }

    public void setReview(List<Review> review) {
        this.reviews = review;
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public void removeReview(Review review){
        reviews.remove(review);
    }

    public void addOrders(Orders order){
        orders.add(order);
    }

    public void removeOrders(Orders order){
        orders.remove(order);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telefon=" + telefon +
                '}';
    }






}
