package Entities;

public class Client {
    private int id;
    private  String  name;
    private String  address;
    private double telefon;
    private Orders[] orders;
    private Cart cart;
    private Review[] review;

    public Client(int id,String name, String address, double telefon, Orders[] orders, Cart cart,
                  Review[] review) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telefon = telefon;
        this.orders = orders;
        this.cart = cart;
        this.review = review;
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

    public Orders[] getOrders() {
        return orders;
    }

    public void setOrders(Orders[] orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Review[] getReview() {
        return review;
    }

    public void setReview(Review[] review) {
        this.review = review;
    }
}
