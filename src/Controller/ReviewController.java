package Controller;
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

    public void save(List<Review> review) {
        reviewRepo.save(review);
    }

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
        List<Review> reviewList = loadReview();
        boolean found = false;

        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getId() == id) {
                review.setComment(comment);
                found = true;
                break;
            }
        }
        if (found) {
            save(reviewList);
            System.out.println("Review with ID " + id + " has been updated.");
        } else {
            System.out.println("Review with ID " + id + " not found.");
        }
    }

    public void updateteStars(int id, String stars){
        List<Review> reviewList = loadReview();
        boolean found = false;

        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getId() == id) {
                review.setStars(stars);
                found = true;
                break;
            }
        }
        if (found) {
            save(reviewList);
            System.out.println("Review with ID " + id + " has been updated.");
        } else {
            System.out.println("Review with ID " + id + " not found.");
        }
    }

    public List<Review> filteredByStars(String stars) {
        List<Review> review = loadReview();
        List<Review> filteredReview = new ArrayList<>();
        for (Review item : review) {
            if (item.getStars() == stars)
                filteredReview.add(item);
        }
        return filteredReview;

    }

    public List<Review> filteredByDate(String date) {
        List<Review> review = loadReview();
        List<Review> filteredReview = new ArrayList<>();
        for (Review item : review) {
            if (item.getDate() == date)
                filteredReview.add(item);
        }
        return filteredReview;

    }
}