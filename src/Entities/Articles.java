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

    private List<Order> orders= new ArrayList<>();

    private List<Integer> specificationIds = new ArrayList<>();


    public List<Integer> getSpecificationIds() {
        return specificationIds;
    }

    public void setSpecificationIds(List<Integer> specificationIds) {
        this.specificationIds = specificationIds;
    }

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
        specificationIds.add(specification.getId());
    }

    public void removeSpecifications(Specifications specification){
        specificationIds.remove(specification.getId());
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public void removeReview(Review review){
        reviews.remove(review);
    }



    public void addOrders(Order orderItem){
        orders.add(orderItem);
    }

    public void removeOrders(Order orderItem){
        orders.remove(orderItem);
    }
}

