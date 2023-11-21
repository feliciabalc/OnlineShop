package DB_Controller;

import DB_Repo.ArticleRepoDB;
import Entities.Articles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleControllerDB {
    private  ArticleRepoDB articleRepo;

    public ArticleControllerDB(ArticleRepoDB articleRepo) {
        this.articleRepo = articleRepo;
    }

    public void saveIntoDB(List<Articles> articles) {
        articleRepo.saveIntoDB(articles);
    }

    public List<Articles> loadFromDB(){
        return articleRepo.loadFromDB();
    }

    public Articles createArticleFromResultSet(ResultSet resultSet) throws SQLException {
        return articleRepo.createArticleFromResultSet(resultSet);
    }


    public Articles findById(int Id){
        return articleRepo.findById(Id);
    }

    public void delete(int Id) {
        articleRepo.delete(Id);
    }

    public void update(int Id, Articles updatedArticle) {
        articleRepo.update(Id,updatedArticle);
    }

    public void updatePrice(int Id, double newPrice) {
        articleRepo.updatePrice(Id,newPrice);
    }

    public List<Articles> filterByBrand(String brand) {
        return articleRepo.filterByBrand(brand);
    }

    public List<Articles> sortByPriceAsc() {
        return articleRepo.sortByPriceAsc();
    }


}
