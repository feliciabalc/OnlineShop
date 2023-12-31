package Entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private double orderNumber;
    private float totalAmount;
    private  String paymentMethod;
    private String address;
    private String date;
    private List<Articles> articles= new ArrayList<>();
    private PaymentStrategy paymentStrategy;


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        paymentStrategy.processPayment(this);
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public Order(int id, double orderNumber, float totalAmount, String paymentMethod, String address,
                 String date) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.date = date;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(double orderNumber) {
        this.orderNumber = orderNumber;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                '}';
    }



    public void addArticle(Articles article){
        articles.add(article);
    }

    public void removeArticle(Articles article){
        articles.remove(article);
    }
}
