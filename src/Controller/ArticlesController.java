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

        articlesRepo.addSpecificationsToArticle(a1,1);

        articlesRepo.addReviewToArticle(a2,1);

        articlesRepo.addCartToArticle(a2,1);
        articlesRepo.addCartToArticle(a1,2);

        articlesRepo.addOrderToArticle(a1,1);

        articlesRepo.addWarehouseToArticle(a1, 1);

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


    public void addSpecificationsToArticle(Articles article, int id){
        articlesRepo.addSpecificationsToArticle(article, id);
    }

    public void removeSpecificationsToArticle(Articles article, int id){
        articlesRepo.removeSpecificationsToArticle(article, id);
    }

    public void addCartToArticle(Articles article, int id){
       articlesRepo.addCartToArticle(article, id);
    }

    public void removeCartToArticle(Articles article, int id){
        articlesRepo.removeCartToArticle(article, id);
    }

    public void addOrderToArticle(Articles article, int id){
       articlesRepo.addOrderToArticle(article, id);
    }

    public void removeOrderToArticle(Articles article, int id){
       articlesRepo.removeOrderToArticle(article, id);
    }

    public void addReviewToArticle(Articles article, int id){
        articlesRepo.addReviewToArticle(article, id);
    }

    public void removeReviewToArticle(Articles article, int id){
        articlesRepo.removeReviewToArticle(article, id);
    }

    public void addWarehouseToArticle(Articles article, int id){
        articlesRepo.addWarehouseToArticle(article, id);
    }

    public void removeWarehouseToArticle(Articles article, int id){
        articlesRepo.addWarehouseToArticle(article, id);
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
