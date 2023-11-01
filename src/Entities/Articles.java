package Entities;

import java.util.ArrayList;
import java.util.List;

public class Articles {
    private int id;
    private String name;
    private String brand;
    private String material;
    private String type;
    private float price;
    private List<Specifications> specifications= new ArrayList<>();
    private List<Review> reviews= new ArrayList<>();
    private List<Cart> cart= new ArrayList<>();
    private List<Orders> orders= new ArrayList<>();
    private List<Warehouse> warehouse= new ArrayList<>();

    public List<Specifications> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specifications> specifications) {
        this.specifications = specifications;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }

    public Articles(int id, String name, String brand, String material, String type, float price) {
        this.id= id;
        this.name = name;
        this.brand = brand;
        this.material = material;
        this.type = type;
        this.price = price;
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

    public String getBrand() {
        return brand;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public void addSpecifications(Specifications specification){
        specifications.add(specification);
    }

    public void removeSpecifications(Specifications specification){
        specifications.remove(specification);
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public void removeReview(Review review){
        reviews.remove(review);
    }

    public void addCart(Cart cartItem){
        cart.add(cartItem);
    }

    public void removeCart(Cart cartItem){
        cart.remove(cartItem);
    }

    public void addWarehouse(Warehouse warehouseItem){
        warehouse.add(warehouseItem);
    }

    public void removeWarehouse(Warehouse warehouseItem){
        warehouse.remove(warehouseItem);
    }
    public void addOrders(Orders orderItem){
        orders.add(orderItem);
    }

    public void removeOrders(Orders orderItem){
        orders.remove(orderItem);
    }
}

