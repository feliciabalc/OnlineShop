package Controller;
import Entities.*;
import Repository.ArticlesRepo;
import Repository.ReviewRepo;
import Repository.SpecificationsRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArticlesController {
    private static ArticlesRepo articlesRepo;
    private static SpecificationsRepo specificationsRepo;
    private static ReviewRepo reviewRepo;

    public ArticlesController(ArticlesRepo articlesRepo, SpecificationsRepo specificationsRepo, ReviewRepo reviewRepo) {
        this.articlesRepo = articlesRepo;
        this.specificationsRepo = specificationsRepo;
        this.reviewRepo = reviewRepo;
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

        articlesRepo.addSpecificationsToArticle(a1,specificationsRepo.findById(1));

        articlesRepo.addReviewToArticle(a2,reviewRepo.findById(1));

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
        Specifications specifications = specificationsRepo.findById(id);
        articlesRepo.addSpecificationsToArticle(article, specifications);
    }

    public void removeSpecificationsToArticle(Articles article,int id){
        Specifications specifications = specificationsRepo.findById(id);
        articlesRepo.removeSpecificationsToArticle(article, specifications);
    }


    public void addReviewToArticle(Articles article, int id){
        Review review=reviewRepo.findById(id);
        articlesRepo.addReviewToArticle(article, review);
    }

    public void removeReviewToArticle(Articles article, int id){
        Review review=reviewRepo.findById(id);
        articlesRepo.removeReviewToArticle(article, review);
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
