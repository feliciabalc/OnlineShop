package Controller;
import Entities.Articles;
import Entities.Client;
import Entities.Review;
import Repository.ReviewRepo;

import java.util.ArrayList;
import java.util.List;

public class ReviewController {
    private ReviewRepo reviewRepo;

    public ReviewController(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public ReviewRepo getReviewRepo() {
        return reviewRepo;
    }

    public void setReviewRepo(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }


    public List<Review> loadReview() {
        return reviewRepo.loadReview();
    }

    public void save() {
        Review rev1=new Review(1,"5 stars","de calitate","10.10.2023");
        Review rev2=new Review(2,"5 stars","foarte bun","13.10.2023");
        Review rev3=new Review(3,"4 stars","excelent","11.10.2023");
        List<Review> review = new ArrayList<>();
        review.add(rev1);
        review.add(rev2);
        review.add(rev3);


        reviewRepo.save(review);
    }

    public void saveOneObj(Review review){ reviewRepo.saveOneObj(review);}

    public void deleteObj(Review review){ reviewRepo.deleteObj(review);}

    public List<Review> findAll() {
        return reviewRepo.loadReview();
    }

    public Review findById(int Id) {

        return reviewRepo.findById(Id);
    }

    public void delete(int id) {
        reviewRepo.delete(id);
    }

    public void updateTheReview(int id, Review review) {
        reviewRepo.update(id, review);
    }

    public void updateComment(int id, String comment){
       reviewRepo.updateComment(id, comment);
    }

    public void updateteStars(int id, String stars){
       reviewRepo.updateteStars(id, stars);
    }


    public List<Review> filteredByStars(String stars) {
        return reviewRepo.filteredByStars(stars);
    }

    public List<Review> filteredByDate(String date) {
       return reviewRepo.filteredByDate(date);

    }


}
