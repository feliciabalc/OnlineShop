package Entities;

public class Orders {
    private double orderNumber;
    private float totalAmount;
    private  String paymentMethod;
    private String address;
    private String date;
    private Employees[] employees;
    private Client client;
    private Courier courier;
    private Articles[] articles;

    public Orders(double orderNumber, float totalAmount, String paymentMethod, String address,
                  String date, Employees[] employees, Client client, Courier courier, Articles[] articles) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.address = address;
        this.date = date;
        this.employees = employees;
        this.client = client;
        this.courier = courier;
        this.articles = articles;
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

    public Employees[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employees[] employees) {
        this.employees = employees;
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

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }
}
