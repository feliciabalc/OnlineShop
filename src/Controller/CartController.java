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

    public void addArticlesToCart(Articles article, Cart cart){
        cartRepo.addArticlesToCart(article, cart);
    }

    public void removeArticlesToCart(Articles article, Cart cart){
        cartRepo.removeArticlesToCart(article, cart);
    }

    public void save() {
        Cart cart1= new Cart(1,5) ;
        Cart cart2= new Cart(1,2) ;
        Cart cart3= new Cart(1,34) ;
        Cart cart4= new Cart(1,9) ;
        List<Cart> carts = new ArrayList<>();
        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);
        carts.add(cart4);
        cartRepo.save(carts);

        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        cart1.addArticles(a1);
    }

    public void saveOneObj(Cart cart){ cartRepo.saveOneObject(cart);}

    public void deleteObj(Cart cart){ cartRepo.deleteObj(cart);}

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
        cartRepo.updateQuantity(id, quantity);
    }
    public void updateteArticles(int id, Articles article, Articles newArticle) {
        cartRepo.updateteArticles(id, article, newArticle);
    }
}
