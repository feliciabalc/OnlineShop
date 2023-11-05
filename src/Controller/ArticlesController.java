package Controller;
import Entities.*;
import Repository.ArticlesRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArticlesController {
    private static ArticlesRepo articlesRepo;

    public ArticlesController(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }

    public ArticlesRepo getArticlesRepo() {
        return articlesRepo;
    }


    public static List<Articles> load() {
        return articlesRepo.loadArticles();
    }

    public static void save() {
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 2);
        Articles a3 = new Articles(5,"top", "nike", "tafta", "maneca", 35);
        Articles a4 = new Articles(6,"pantaloni", "nike", "elastan","scurti", 100);
        List<Articles> articles = new ArrayList<>();
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);

        Specifications sp1=new Specifications(1, new String[]{"S", "M"},"rosu",25,true);
        a1.addSpecifications(sp1);

        Review rev1=new Review(1,"5 stars","de calitate","10.10.2023");
        a1.addReview(rev1);

        Cart cart1= new Cart(1,5) ;
        Cart cart2= new Cart(1,2) ;
        a1.addCart(cart1);

        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        a1.addOrders(o1);

        Warehouse war1= new Warehouse(1,"R&F","Gruia 58");

        System.out.println("printing");
        articlesRepo.save(articles);

    }

    public List<Articles> findAll() {
        return articlesRepo.loadArticles();
    }

    public Articles findById(int Id) {

        return articlesRepo.findById(Id);
    }

    public void delete(int id) {
        articlesRepo.delete(id);
    }

    public void updateTheArticle(int id, Articles article) {
        articlesRepo.update(id, article);
    }


    public List<Articles> filteredByBrand(String brand) {
        return articlesRepo.filteredByBrand(brand);

    }
    public void saveOneObject(Articles article){
        articlesRepo.saveOneObject(article);
    }

    public void deleteObj(Articles article){ articlesRepo.deleteObj(article);}


    public void addSpecificationsToArticle(Articles article, Specifications specification){
        articlesRepo.addSpecificationsToArticle(article, specification);
    }

    public void removeSpecificationsToArticle(Articles article, Specifications specification){
        articlesRepo.removeSpecificationsToArticle(article, specification);
    }

    public void addCartToArticle(Articles article, Cart cart){
       articlesRepo.addCartToArticle(article, cart);
    }

    public void removeCartToArticle(Articles article, Cart cart){
        articlesRepo.removeCartToArticle(article, cart);
    }

    public void addOrderToArticle(Articles article, Orders order){
       articlesRepo.addOrderToArticle(article, order);
    }

    public void removeOrderToArticle(Articles article, Orders order){
       articlesRepo.removeOrderToArticle(article, order);
    }

    public void addReviewToArticle(Articles article, Review review){
        articlesRepo.addReviewToArticle(article, review);
    }

    public void removeReviewToArticle(Articles article, Review review){
        articlesRepo.removeReviewToArticle(article, review);
    }

    public void addWarehouseToArticle(Articles article, Warehouse warehouse){
        articlesRepo.addWarehouseToArticle(article, warehouse);
    }

    public void removeWarehouseToArticle(Articles article, Warehouse warehouse){
        articlesRepo.addWarehouseToArticle(article, warehouse);
    }






    public List<Articles> filteredByMaterial(String material) {
        return articlesRepo.filteredByMaterial(material);


    }

    public List<Articles> sortPriceAsc() {
        return articlesRepo.sortPriceAsc();
    }



    public List<Articles> sortPriceDesc() {
        return articlesRepo.sortPriceDesc();
    }

    public void updateName(int id, String name){
        articlesRepo.updateName(id, name);
    }

    public void updatePrice(int id, float price){
        articlesRepo.updatePrice(id, price);
    }

}
