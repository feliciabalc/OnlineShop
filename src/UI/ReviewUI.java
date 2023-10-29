package UI;

import Controller.ReviewController;

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
}
