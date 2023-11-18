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

    public void addArticlesToCart( Cart cart,int id){
        cartController.addArticlesToCart(cart,id);}

    public void removeArticlesToCart(Cart cart,int id){
        cartController.removeArticlesToCart(cart,id);}

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
    public void updateQuantity(int id, double quantity) {

            cartController.updateQuantity(id, quantity);
            System.out.println("Cart quantity updated successfully!");

    }

    public void updateArticles(int id, int articlesId, Articles newArticle) {
            cartController.updateteArticles(id, articlesId, newArticle);
    }

    public void updateTheCart(int id, Cart cart) {
        cartController.updateTheCart(id, cart);}




    }
