package Entities;

public class Suppliers {
    private int id;
    private  String name;
    private  double telefon;
    private String articleType;
    private Warehouse warehouse;

    public Suppliers(int id,String name, double telefon, String articleType, Warehouse warehouse) {
        this.id = id;
        this.name = name;
        this.telefon = telefon;
        this.articleType = articleType;
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
