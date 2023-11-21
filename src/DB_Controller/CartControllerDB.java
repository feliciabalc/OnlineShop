package DB_Controller;


import DB_Repo.CartRepoDB;
import Entities.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartControllerDB {
    private CartRepoDB cartRepoDB;

    public CartControllerDB(CartRepoDB cartRepoDB) {
        this.cartRepoDB = cartRepoDB;
    }

    public void saveIntoDB(List<Cart> carts) {
        cartRepoDB.saveIntoDB(carts);
    }

    private Cart createCartFromResultSet(ResultSet resultSet) throws SQLException {
        return cartRepoDB.createCartFromResultSet(resultSet);
    }

    public List<Cart> loadFromDB() {
        return cartRepoDB.loadFromDB();
    }

    public Cart findById(int Id){
        return cartRepoDB.findById(Id);
    }

    public void delete(int Id) {
        cartRepoDB.delete(Id);
    }

    public void updateQuantity(int Id, double Quantity) {
        cartRepoDB.updateQuantity(Id, Quantity);
    }
}
