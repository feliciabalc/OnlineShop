package Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private int id;
    private double orderNumber;
    private float totalAmount;
    private  String paymentMethod;
    private String address;
    private String date;
    private List<Employee> employees=new ArrayList<>();
    private Client client;
    private Courier courier;
    private List<Articles> articles= new ArrayList<>();

    public Orders(int id, double orderNumber, float totalAmount, String paymentMethod, String address,
                  String date) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.date = date;
    }

    private ClientOrderObserver observer;

    public void addObserver(ClientOrderObserver addObserver) {
        this.observer = addObserver;
    }

    public void removeObserver() {
        this.observer = null;
    }

    public void notifyObservers() {

            observer.update(this);
    }

    public OrderObserver getObserver() {
        return observer;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public void addArticle(Articles article){
        articles.add(article);
    }

    public void removeArticle(Articles article){
        articles.remove(article);
    }
}
