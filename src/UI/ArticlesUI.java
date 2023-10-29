package UI;

import Controller.ArticlesController;
import Entities.Articles;

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

    public void saveArticles(List<Articles> articles) {
        articlesController.save(articles);}

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


}
