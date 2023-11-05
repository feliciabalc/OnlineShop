package Repository;

import Entities.Articles;
import Entities.Client;
import Entities.Orders;
import Entities.Review;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepo extends AbstractRepo {
    public ReviewRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Review review){
        List<Review> reviews =loadReview();
        for(Review item : reviews)
            if(item.getId()== review.getId())
                item = review;
            else
                reviews.add(review);
        save(reviews);
    }

    public void deleteObj(Review review){
        List<Review> allReview =loadReview();
        allReview.remove(review);
        save(allReview);
    }

    public List<Review> loadReview() {
        Type reviewListType = new TypeToken<List<Review>>() {}.getType();
        return load(reviewListType);
    }
    public List<Review> findAll(){
        return loadReview();
    }


    public Review findById(int Id){
        List<Review> allReview = loadReview();
        Review foundItem = null;
        for(Review item : allReview){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Review> reviewList = loadReview();
        Review foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < reviewList.size(); i++) {
            Review item = reviewList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            reviewList.remove(indexToRemove);
            save(reviewList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }

    public void update(int id, Review updatedReview) {
        List<Review> reviewList = loadReview();
        boolean found = false;

        for (int i = 0; i < reviewList.size(); i++) {
            Review review = reviewList.get(i);
            if (review.getId() == id) {
                review.setStars(updatedReview.getStars());
                review.setComment(updatedReview.getComment());
                review.setDate(updatedReview.getDate());
                found = true;
                break;
            }
        }
        if (found) {
            save(reviewList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }
    public void setClient(Client client) {client = client;}

    public void setArticle(Articles article) {article = article;}

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