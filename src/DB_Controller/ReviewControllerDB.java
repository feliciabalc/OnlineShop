package DB_Controller;

import DB_Repo.ReviewRepoDB;
import Entities.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReviewControllerDB {
    private ReviewRepoDB reviewRepo;

    public ReviewControllerDB(ReviewRepoDB reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public void saveIntoDB(List<Review> reviews) {
        reviewRepo.saveIntoDB(reviews);
    }

    public Review createReviewFromResultSet(ResultSet resultSet) throws SQLException {
        return reviewRepo.createReviewFromResultSet(resultSet);
    }

    public List<Review> loadFromDB() {
        return reviewRepo.loadFromDB();
    }

    public Review findById(int Id) {
        return reviewRepo.findById(Id);
    }

    public void delete(int Id) {
        reviewRepo.delete(Id);
    }

    public void updateComment(int Id, String newComment) {
        reviewRepo.updateComment(Id, newComment);
    }

    public void updateStars(int Id, String stars) {
        reviewRepo.updateStars(Id, stars);
    }

    public List<Review> filterByStars(String stars) {
        return reviewRepo.filterByStars(stars);
    }
}
