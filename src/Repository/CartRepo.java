package Repository;

import Entities.Articles;
import Entities.Cart;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

}