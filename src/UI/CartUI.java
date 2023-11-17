package UI;

import Controller.CartController;
import Entities.Articles;
import Entities.Cart;
import Repository.ArticlesRepo;
import Repository.SpecificationsRepo;

import java.util.List;
import java.util.Scanner;

public class CartUI {
    private CartController cartController;

    public CartUI(CartController cartController) {
        this.cartController = cartController;
    }

    public CartController getCartController() {
        return cartController;
    }

    public void setCartController(CartController cartController) {
        this.cartController = cartController;
    }

    public List<Cart> loadCart() {
        return cartController.loadCart();}

    public void addArticlesToCart(Articles article, Cart cart){
        cartController.addArticlesToCart(article, cart);}

    public void removeArticlesToCart(Articles article, Cart cart){
        cartController.removeArticlesToCart(article, cart);}

    public void save() {
        cartController.save();}

    public void saveOneObj(Cart cart){
        cartController.saveOneObj(cart);}

    public void deleteObj(Cart cart){ cartController.deleteObj(cart);}

    public List<Cart> findAll() {
        return cartController.findAll();}

    public Cart findById(int Id) {
        return cartController.findById(Id);}

    public void delete(int id) {
        cartController.delete(id);}
    public void updateQuantity() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter cart ID to update quantity:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new quantity:");
            double quantity = Double.parseDouble(scanner.nextLine());

            cartController.updateQuantity(id, quantity);
            System.out.println("Cart quantity updated successfully!");
        } catch (NumberFormatException e) {
            handleUserInputError();
        }
    }

    public void updateArticles() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter cart ID to update articles:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter article ID to update:");
            int articleId = Integer.parseInt(scanner.nextLine());
            String orderFile ="OrdersFile.json";
            String specificationFile = "SpecificationsFile.json";
            String cartFile = "CartFile.json";
            String warehouseFile = "WarehouseFile.json";
            String reviewFile = "ReviewFile.json";
            ArticlesRepo articlesRepo = new ArticlesRepo("ArticlesFile.json",specificationFile,reviewFile,cartFile,orderFile,warehouseFile);
            Articles article = articlesRepo.findById(articleId);

            System.out.println("Enter id:");
            int newArticleid = Integer.parseInt(scanner.nextLine());
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


            cartController.updateteArticles(id, article, newArticle);
            System.out.println("Cart articles updated successfully!");
        } catch (NumberFormatException e) {
            handleUserInputError();
        }
    }

    public void updateTheCart(int id, Cart cart) {
        cartController.updateTheCart(id, cart);}


    public void handleUserInputError() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Invalid input. Please try again.");
        scanner.nextLine(); // Consume the invalid input
    }

    }
