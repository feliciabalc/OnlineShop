package UI;

import Controller.ReviewController;
import Entities.Articles;
import Entities.Client;
import Entities.Review;
import Repository.ArticlesRepo;
import Repository.ClientRepo;

import java.util.List;
import java.util.Scanner;

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

    public void save() {
        reviewController.save();}

    public void addReview(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me id, number of stars, comment, date, your id and also the id of the reviewed article");
        int id = Integer.parseInt(scanner.nextLine());
        String stars = String.valueOf(scanner.nextLine());
        String comment = String.valueOf(scanner.nextLine());
        String date = String.valueOf(scanner.nextLine());
        int ClientId = Integer.parseInt(scanner.nextLine());
        int ArticleId = Integer.valueOf(Integer.parseInt(scanner.nextLine()));
        Review newR = new Review(id, stars, comment, date);

        ArticlesRepo articlesRepo = new ArticlesRepo("ReviewFile.json");
        ClientRepo clientRepo = new ClientRepo("ClientFile.json");
        Articles article = articlesRepo.findById(ArticleId);
        Client client = clientRepo.findById(ClientId);
        newR.setArticle(article);
        newR.setClient(client);
        reviewController.saveOneObj(newR);}

    public void deleteObj(Review review){ reviewController.deleteObj(review);}

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
