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

    public void setArticlesRepo(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }






    public static List<Articles> load() {
        return articlesRepo.loadArticles();
    }

    public static void save(List<Articles> articles) {
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 2);
        Articles a3 = new Articles(5,"top", "nike", "tafta", "maneca", 35);
        Articles a4 = new Articles(6,"pantaloni", "nike", "elastan","scurti", 100);
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
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
        List<Articles> articles = load();
        List<Articles> filteredArticles = new ArrayList<>();
        for (Articles item : articles) {
            if (item.getBrand() == brand)
                filteredArticles.add(item);
        }
        return filteredArticles;


    }
    public void saveOneObject(Articles article){
        articlesRepo.saveOneObject(article);
    }


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
        List<Articles> articles = load();
        List<Articles> filteredArticles = new ArrayList<>();
        for (Articles item : articles) {
            if (item.getMaterial() == material)
                filteredArticles.add(item);
        }
        return filteredArticles;


    }
    Comparator<Articles> artComparator = new Comparator<Articles>() {
        @Override
        public int compare(Articles a1, Articles a2) {
            int comparisonResult = (int) (a1.getPrice() - a2.getPrice());

            return comparisonResult;
        }
    };
    public List<Articles> sortPriceAsc() {
        List<Articles> articles = load();
        articles.sort(artComparator);
        return articles;
    }

    Comparator<Articles> artComparatorDesc = new Comparator<Articles>() {
        @Override
        public int compare(Articles a1, Articles a2) {
            int comparisonResult = (int) (a1.getPrice() - a2.getPrice());

            return comparisonResult*-1;
        }
    };

    public List<Articles> sortPriceDesc() {
        List<Articles> articles = load();
        articles.sort(artComparatorDesc);
        return articles;
    }

    public void updateName(int id, String name){
        List<Articles> articlesList = load();
        boolean found = false;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles article = articlesList.get(i);
            if (article.getId() == id) {
                article.setName(name);
                found = true;
                break;
            }
        }
        if (found) {
            save(articlesList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }

    public void updatePrice(int id, float price){
        List<Articles> articlesList = load();
        boolean found = false;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles article = articlesList.get(i);
            if (article.getId() == id) {
                article.setPrice(price);
                found = true;
                break;
            }
        }
        if (found) {
            save(articlesList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }

}
