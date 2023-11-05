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

    public void addNewArticle() {
        try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter id:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter brand:");
                String brand = scanner.nextLine();
                System.out.println("Enter material:");
                String material = scanner.nextLine();
                System.out.println("Enter type:");
                String type = scanner.nextLine();
                System.out.println("Enter price:");
                float price = Float.parseFloat(scanner.nextLine());

                Articles newArticle = new Articles(id, name, brand, material, type, price);
                articlesController.saveOneObject(newArticle);
                System.out.println("Article added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
        }
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

    public void deleteArticle() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter article ID to delete:");
            int id = Integer.parseInt(scanner.nextLine());
            articlesController.delete(id);
            System.out.println("Article deleted successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
        }
    }

    public void updateArticlePrice() {
        try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter article ID to update price:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new price:");
                String price = scanner.nextLine();
                articlesController.updatePrice(id, Float.parseFloat(price));
                System.out.println("Article price updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
        }
    }

    public void updateArticle() {
       try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter article ID to update:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                System.out.println("Enter new brand:");
                String brand = scanner.nextLine();
                System.out.println("Enter new material:");
                String material = scanner.nextLine();
                System.out.println("Enter new type:");
                String type = scanner.nextLine();
                System.out.println("Enter new price:");
                float price = Float.parseFloat(scanner.nextLine());

                Articles updatedArticle = new Articles(id, name, brand, material, type, price);
                articlesController.updateTheArticle(id, updatedArticle);
                System.out.println("Article updated successfully!");
       } catch (NumberFormatException e) {
           System.out.println("Invalid input. Please enter a valid input");
       }
    }

    public void filterByBrand() {
        try{
                Scanner scanner= new Scanner(System.in);
                System.out.println("Enter brand to filter articles:");
                String brand = scanner.nextLine();
                List<Articles> filteredArticles = articlesController.filteredByBrand(brand);
                for (Articles article : filteredArticles) {
                    System.out.println(article);
                }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
        }
    }

    public void filterByMaterial() {
        try{
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter material to filter articles:");
            String material = scanner.nextLine();
            List<Articles> filteredArticles = articlesController.filteredByMaterial(material);
            for (Articles article : filteredArticles) {
                System.out.println(article);

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
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

    public void updateArticleName() {
        try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter article ID:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                articlesController.updateName(id, name);
                System.out.println("Article name updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid input");
        }
    }



    public void saveOneObject(Articles article){
        articlesController.saveOneObject(article);
    }


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

    public void handleUserInputError() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Invalid input. Please try again.");
        scanner.nextLine(); // Consume the invalid input
    }




}
