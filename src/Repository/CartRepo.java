package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CartRepo extends AbstractRepo {

    public CartRepo(String fileName) {
        super(fileName);
    }


    @Override
    public void save(List objects) {
        super.save(objects);
    }


    public List<Cart> loadCart() {
        Type cartListType = new TypeToken<List<Cart>>() {}.getType();
        return load(cartListType);
    }






    public void saveOneObject(Cart cart){

        List<Cart> allCarts =loadCart();
        boolean found = false;

        Iterator<Cart> iterator = allCarts.iterator();
        while (iterator.hasNext()) {
            Cart item = iterator.next();
            if (item.getId() == cart.getId()) {
                iterator.remove();
                allCarts.add(cart);
                found = true;
                break;
            }
        }

        if (!found) {
            allCarts.add(cart);
        }

        save(allCarts);
    }

    public void deleteObj(Cart cart){
        List<Cart> allCart =loadCart();
        allCart.remove(cart);
        save(allCart);
    }

    public List<Cart> findAll(){
        return loadCart();
    }


    public Cart findById(int Id){
        List<Cart> allCart = loadCart();
        Cart foundItem = null;
        for(Cart item : allCart){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Cart> cartList = loadCart();
        Cart foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < cartList.size(); i++) {
            Cart item = cartList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            cartList.remove(indexToRemove);
            save(cartList);
            System.out.println("Article with ID " + Id + " has been deleted.");
        } else {
            System.out.println("Article with ID " + Id + " not found.");
        }
    }



    public void update(int id, Cart updatedCart) {
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getId() == id) {
                cart.setQuantity(updatedCart.getQuantity());
                found = true;
                break;
            }
        }

        if (found) {
            save(cartList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }



    public void addArticlesToCart(Cart cart, Articles article){
        cart.addArticles(article);
        saveOneObject(cart);
        cart.notifyObservers();
    }

    public void removeArticlesToCart(Cart cart, Articles article){
        cart.removeArticles(article);
        saveOneObject(cart);
        cart.notifyObservers();
    }

    public void updateQuantity(int id, double quantity){
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getId() == id) {
                cart.setQuantity(quantity);
                cart.notifyObservers();
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
    public void updateteArticles(int id, Articles articleToUpdate, Articles newArticle) {
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getId() == id) {
                Articles article = articleToUpdate;
                cart.addArticles(article);
                found = true;
            }
        }
        if (found) {
            save(cartList);
            System.out.println("Cart with ID " + id + " has been updated.");
        } else {
            System.out.println("Cart with ID " + id + " not found.");
        }
    }
    public void updatePriceArticle(int id, int articleId, int newPrice){
        List<Cart> cartList = loadCart();
        boolean found = false;

        for (int i = 0; i < cartList.size(); i++) {
            Cart cart = cartList.get(i);
            if (cart.getId() == id) {
                List<Articles> articles = cart.getArticles();
                for (int j = 0; j < articles.size(); j++) {
                    Articles articles1 = articles.get(j);
                    if (articles1.getId() == articleId) {
                        found = true;
                        articles1.setPrice(newPrice);
                        cart.notifyObservers();
                    }
                }
            }

        }
        if (found) {
            save(cartList);
            System.out.println("Cart with ID " + id + " has been updated.");
        } else {
            System.out.println("Cart with ID " + id + " not found.");
        }
    }




   public List<ClientCartObserver> getObservers(Cart cart){
        return getObservers(cart);
    }



}