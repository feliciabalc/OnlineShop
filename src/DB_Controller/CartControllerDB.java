package DB_Controller;


import DB_Repo.ArticleRepoDB;
import DB_Repo.CartRepoDB;
import Entities.Articles;
import Entities.Cart;
import Entities.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartControllerDB {
    private CartRepoDB cartRepoDB;

    private ArticleRepoDB articleRepoDB;

    public CartControllerDB(CartRepoDB cartRepoDB, ArticleRepoDB articleRepoDB) {
        this.cartRepoDB = cartRepoDB;
        this.articleRepoDB = articleRepoDB;
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

    public Articles getArticle(int cartId){
        Articles article = null;
        if(cartRepoDB.getArticleId(cartId) != -1) {
            int aId = cartRepoDB.getArticleId(cartId);
            article  = articleRepoDB.findById(aId);
        }
        return article;
    }
}
