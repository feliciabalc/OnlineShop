package Controller;

import Entities.Articles;
import Entities.Cart;
import Entities.Employee;
import Entities.Orders;
import Repository.CartRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CartController {
    private CartRepo cartRepo;

    public CartController(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public CartRepo getCartRepo() {
        return cartRepo;
    }

    public void setCartRepo(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }


    public List<Cart> loadCart() {
        return cartRepo.loadCart();
    }

    public void save(List<Cart> carts) {
        cartRepo.save(carts);
    }

    public List<Cart> findAll() {
        return cartRepo.loadCart();
    }

    public Cart findById(int Id) {

        return cartRepo.findById(Id);
    }

    public void delete(int id) {
        cartRepo.delete(id);
    }

    public void updateTheCart(int id, Cart cart) {
        cartRepo.update(id, cart);
    }



    public void updateQuantity(int id, double quantity){
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getQuantity() == quantity) {
                cart.setQuantity(quantity);
                found = true;
                break;
            }
        }
        if (found) {
            save(cartList);
            System.out.println("Cart with ID " + id + " has been updated.");
        } else {
            System.out.println("Cart with ID " + id + " not found.");
        }
    }
    public void updateteArticles(int id, Articles article, Articles newArticle) {
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getId() == id) {
                Articles[] articles = cart.getArticles();
                for (int j = 0; j <= articles.length; j++)
                    if (articles[j] == article) {
                        articles[j] = newArticle;
                        found = true;
                        break;
                    }
            }
        }
        if (found) {
            save(cartList);
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }
}
