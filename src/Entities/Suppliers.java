package Entities;

public class Suppliers {
    private  String name;
    private  double telefon;
    private String articleType;
    private Warehouse warehouse;

    public Suppliers(String name, double telefon, String articleType, Warehouse warehouse) {
        this.name = name;
        this.telefon = telefon;
        this.articleType = articleType;
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTelefon() {
        return telefon;
    }

    public void setTelefon(double telefon) {
        this.telefon = telefon;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
