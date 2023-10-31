package UI;

import Controller.CartController;
import Entities.Articles;
import Entities.Cart;

import java.util.List;

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

    public void save(List<Cart> carts) {
        cartController.save(carts);}

    public void saveOneObj(Cart cart){
        cartController.saveOneObj(cart);}

    public List<Cart> findAll() {
        return cartController.findAll();}

    public Cart findById(int Id) {
        return cartController.findById(Id);}

    public void delete(int id) {
        cartController.delete(id);}

    public void updateTheCart(int id, Cart cart) {
        cartController.updateTheCart(id, cart);}

    public void updateQuantity(int id, double quantity){
        cartController.updateQuantity(id,quantity);}

    public void updateteArticles(int id, Articles article, Articles newArticle) {
        cartController.updateteArticles(id,article,newArticle);}

    }
