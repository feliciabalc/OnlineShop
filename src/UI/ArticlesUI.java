package UI;

import Controller.ArticlesController;
import Entities.*;

import java.util.List;

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

    public List<Articles> findAll(){
        return articlesController.findAll();}

    public Articles findById(int Id) {
        return articlesController.findById( Id);}

    public void delete(int id) {
        articlesController.delete(id);}

    public void updateTheArticle(int id, Articles article) {
        articlesController.updateTheArticle(id,article);}

    public List<Articles> filteredByBrand(String brand) {
        return articlesController.filteredByBrand(brand);}

    public List<Articles> filteredByMaterial(String material) {
        return articlesController.filteredByMaterial(material);}

    public List<Articles> sortPriceAsc() {
        return articlesController.sortPriceAsc();}

    public List<Articles> sortPriceDesc() {
        return articlesController.sortPriceDesc();}

    public void updateName(int id, String name){
        articlesController.updateName(id,name);}

    public void updatePrice(int id, String price){
        articlesController.updateName(id,price);}

    public void saveOneObject(Articles article){
        articlesController.saveOneObject(article);
    }

    public void deleteObj(Articles article){ articlesController.deleteObj(article);}

    public void addSpecificationsToArticle(Articles article, Specifications specification){
        articlesController.addSpecificationsToArticle(article, specification);
    }

    public void addCartToArticle(Articles article, Cart cart){
        articlesController.addCartToArticle(article, cart);
    }

    public void removeCartToArticle(Articles article, Cart cart){
        articlesController.removeCartToArticle(article, cart);
    }

    public void addOrderToArticle(Articles article, Orders order){
        articlesController.addOrderToArticle(article, order);
    }

    public void removeOrderToArticle(Articles article, Orders order){
        articlesController.removeOrderToArticle(article, order);
    }

    public void addReviewToArticle(Articles article, Review review){
        articlesController.addReviewToArticle(article, review);
    }

    public void removeReviewToArticle(Articles article, Review review){
        articlesController.removeReviewToArticle(article, review);
    }

    public void addWarehouseToArticle(Articles article, Warehouse warehouse){
        articlesController.addWarehouseToArticle(article, warehouse);
    }

    public void removeWarehouseToArticle(Articles article, Warehouse warehouse){
        articlesController.addWarehouseToArticle(article, warehouse);
    }





}
