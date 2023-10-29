package UI;

import Controller.ReviewController;
import Entities.Review;

import java.util.List;

public class ReviewUI {
    private ReviewController reviewController;

    public ReviewUI(ReviewController reviewController) {
        this.reviewController = reviewController;
    }

    public ReviewController getReviewController() {
        return reviewController;
    }

    public void setReviewController(ReviewController reviewController) {
        this.reviewController = reviewController;
    }
    public List<Review> loadReview() {
        return reviewController.loadReview();}

    public void save(List<Review> review) {
        reviewController.save(review);}

    public List<Review> findAll() {
        return reviewController.findAll();}

    public Review findById(int Id) {
        return reviewController.findById(Id);}

    public void delete(int id) {
        reviewController.delete(id);}

    public void updateTheReview(int id, Review review) {
        reviewController.updateTheReview(id,review);}

    public void updateComment(int id, String comment){
        reviewController.updateComment(id, comment);}

    public void updateteStars(int id, String stars){
        reviewController.updateteStars(id,stars);}

    public List<Review> filteredByStars(String stars) {
        return reviewController.filteredByStars(stars);}

    public List<Review> filteredByDate(String date) {
        return reviewController.filteredByDate(date);}

    }
