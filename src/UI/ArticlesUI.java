package UI;

import Controller.ArticlesController;
import Entities.*;

import java.util.List;
import java.util.Scanner;

public class ArticlesUI {
    private ArticlesController articlesController;

    public ArticlesUI(ArticlesController articlesController) {
        this.articlesController = articlesController;
    }

    public ArticlesController getArticlesController() {
        return articlesController;
    }

    public void setArticlesController(ArticlesController articlesController) {
        this.articlesController = articlesController;
    }



    public List<Articles> loadArticles() {
        return articlesController.load();}

    public void saveArticles() {
        articlesController.save();}

    public void displayAllArticles() {
        List<Articles> articles = articlesController.findAll();
        for (Articles article : articles) {
            System.out.println(article);
        }
    }

    public Articles findById(int Id) {

        return articlesController.findById( Id);}

    public void deleteArticle(int id) {

            articlesController.delete(id);
            System.out.println("Article deleted successfully!");
    }

    public void updateArticlePrice(int id, float price) {
                articlesController.updatePrice(id, price);
                System.out.println("Article price updated successfully!");
    }



    public void filterByBrand(String brand) {
                List<Articles> filteredArticles = articlesController.filteredByBrand(brand);
                for (Articles article : filteredArticles) {
                    System.out.println(article);
                }

    }

    public void filterByMaterial(String material) {
            List<Articles> filteredArticles = articlesController.filteredByMaterial(material);
            for (Articles article : filteredArticles) {
                System.out.println(article);

            }

    }

    public void sortArticlesByPriceAsc() {
        List<Articles> sortedArticles = articlesController.sortPriceAsc();
        for (Articles article : sortedArticles) {
            System.out.println(article);
        }
    }

    public void sortArticlesByPriceDesc() {
        List<Articles> sortedArticles = articlesController.sortPriceDesc();
        for (Articles article : sortedArticles) {
            System.out.println(article);
        }
    }


    public void saveOneObject(Articles article){
        articlesController.saveOneObject(article);
    }


    public void addSpecificationsToArticle(Articles article, int id){
        articlesController.addSpecificationsToArticle(article, id);
    }


    public void addReviewToArticle(Articles article, int id){
        articlesController.addReviewToArticle(article, id);
    }

    public void removeReviewToArticle(Articles article, int id){
        articlesController.removeReviewToArticle(article, id);
    }




}
