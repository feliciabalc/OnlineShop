package Entities;

public class Articles {
    private int id;
    private String name;
    private String brand;
    private String material;
    private String type;
    private float price;
    private Specifications[] specifications;
    private Review[] reviews;
    private Cart[] cart;
    private Orders[] orders;
    private Warehouse warehouse;

    public Articles(int id,String name, String brand, String material, String type, float price,
                    Specifications[] specifications, Review[] reviews, Cart[] cart,
                    Orders[] orders, Warehouse warehouse) {
        this.id= id;
        this.name = name;
        this.brand = brand;
        this.material = material;
        this.type = type;
        this.price = price;
        this.specifications = specifications;
        this.reviews = reviews;
        this.cart = cart;
        this.orders = orders;
        this.warehouse = warehouse;
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
}
