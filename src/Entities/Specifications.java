package Entities;

public class Specifications {
    private Articles article;
    private String size;
    private String color;
    private double quantity;
    private boolean availability= getQuantity()>0;

    public Specifications(Articles article, String size, String color, double quantity, boolean availability) {
        this.article = article;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.availability = availability;
    }

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
