package DB_Controller;

import DB_Repo.ArticleRepoDB;
import DB_Repo.ReviewRepoDB;
import DB_Repo.SpecificationsRepoDB;
import Entities.Articles;
import Entities.Review;
import Entities.Specifications;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArticleControllerDB {
    private  ArticleRepoDB articleRepo;
    private SpecificationsRepoDB specificationsRepo;
    private ReviewRepoDB reviewRepo;

    public ArticleControllerDB(ArticleRepoDB articleRepo, SpecificationsRepoDB specificationsRepo, ReviewRepoDB reviewRepo) {
        this.articleRepo = articleRepo;
        this.specificationsRepo = specificationsRepo;
        this.reviewRepo = reviewRepo;
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

    public void addSpecifications(int articleId, int specId){
        articleRepo.addSpecifications(articleId, specId);
    }

    public void addReview(int articleId, int revId){
        articleRepo.addReview(articleId,revId);
    }


    public Specifications getSpec(int articleId){
        Specifications specification = null;
        if(articleRepo.getSpecificationId(articleId) != -1) {
            int specId = articleRepo.getSpecificationId(articleId);
             specification = specificationsRepo.findById(specId);
        }
        return specification;
    }

    public Review getRev(int articleId){
        Review review = null;
        if(articleRepo.getReviewId(articleId) != -1) {
            int revId = articleRepo.getReviewId(articleId);
            review  = reviewRepo.findById(revId);
        }
        return review;
    }



}
