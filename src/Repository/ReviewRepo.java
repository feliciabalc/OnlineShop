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

}