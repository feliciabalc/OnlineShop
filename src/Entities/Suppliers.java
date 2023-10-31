package Entities;

public class Suppliers {
    private int id;
    private  String name;
    private  double telefon;
    private String articleType;
    private Warehouse warehouse;

    public Suppliers(int id,String name, double telefon, String articleType) {
        this.id = id;
        this.name = name;
        this.telefon = telefon;
        this.articleType = articleType;
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

    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telefon=" + telefon +
                ", articleType='" + articleType + '\'' +
                '}';
    }
}
