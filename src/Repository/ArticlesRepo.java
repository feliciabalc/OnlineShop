package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class ArticlesRepo extends AbstractRepo {
    private SpecificationsRepo specificationsRepo;
    private ReviewRepo reviewRepo;


    public ArticlesRepo(String fileName, String specificationFilename, String reviewFilename) {

        super(fileName);
        this.specificationsRepo=new SpecificationsRepo(specificationFilename);
        this.reviewRepo = new ReviewRepo(reviewFilename);

    }


    @Override
    public void save(List objects) {
        super.save(objects);
    }




    public List<Articles> loadArticles() {
        Type articlesListType = new TypeToken<List<Articles>>() {}.getType();
        return load(articlesListType);

    }

    public List<Articles> findAll(){
        return loadArticles();
    }


    public Articles findById(int Id){
        List<Articles> allArticles = loadArticles();
        Articles foundItem = null;
        for(Articles item : allArticles){
                if(item.getId() == Id)
                    foundItem =item;

        }

    return foundItem;
    }

    public void delete(int Id) {
        List<Articles> articlesList = loadArticles();
        Articles foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles item = articlesList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            articlesList.remove(indexToRemove);
            save(articlesList);
            System.out.println("Article with ID " + Id + " has been deleted.");
        } else {
            System.out.println("Article with ID " + Id + " not found.");
        }
    }



    public void update(int id, Articles updatedArticle) {
        List<Articles> articlesList = loadArticles();
        boolean found = false;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles article = articlesList.get(i);
            if (article.getId() == id) {
                article.setName(updatedArticle.getName());
                article.setBrand(updatedArticle.getBrand());
                article.setPrice(updatedArticle.getPrice());
                article.setMaterial(updatedArticle.getMaterial());
                article.setType(updatedArticle.getType());
                found = true;
                break;
            }
        }

        if (found) {
            save(articlesList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }


    public void saveOneObject(Articles article){
        List<Articles> allArticles =loadArticles();
        boolean found = false;
        for (Articles item : allArticles) {
            if (item.getId() == article.getId()) {
                item = article;
                found = true;
                break;
            }
        }
        if (!found) {
            allArticles.add(article);
        }
        save(allArticles);
    }

    public void deleteObj(Articles article){
        List<Articles> allArticles =loadArticles();
        allArticles.remove(article);
        save(allArticles);
    }

    public List<Articles> filteredByBrand(String brand) {
        List<Articles> articles = loadArticles();
        List<Articles> filteredArticles = new ArrayList<>();
        for (Articles item : articles) {
            if (item.getBrand() == brand)
                filteredArticles.add(item);
        }
        return filteredArticles;


    }


    public void addSpecificationsToArticle(Articles article, int id){
        Specifications specification = specificationsRepo.findById(id);
        article.addSpecifications(specification);
        saveOneObject(article);
    }

    public void removeSpecificationsToArticle(Articles article, int id){
        Specifications specification = specificationsRepo.findById(id);
        article.removeSpecifications(specification);
        saveOneObject(article);
    }



    public void addReviewToArticle(Articles article, int id){
        Review review= reviewRepo.findById(id);
        article.addReview(review);
        saveOneObject(article);
    }

    public void removeReviewToArticle(Articles article, int id){
        Review review= reviewRepo.findById(id);
        article.removeReview(review);
        saveOneObject(article);
    }



    public List<Articles> filteredByMaterial(String material) {
        List<Articles> articles = loadArticles();
        List<Articles> filteredArticles = new ArrayList<>();
        for (Articles item : articles) {
            if (item.getMaterial() == material)
                filteredArticles.add(item);
        }
        return filteredArticles;


    }
    Comparator<Articles> artComparator = new Comparator<Articles>() {
        @Override
        public int compare(Articles a1, Articles a2) {
            int comparisonResult = (int) (a1.getPrice() - a2.getPrice());

            return comparisonResult;
        }
    };
    public List<Articles> sortPriceAsc() {
        List<Articles> articles = loadArticles();
        articles.sort(artComparator);
        return articles;
    }

    Comparator<Articles> artComparatorDesc = new Comparator<Articles>() {
        @Override
        public int compare(Articles a1, Articles a2) {
            int comparisonResult = (int) (a1.getPrice() - a2.getPrice());

            return comparisonResult*-1;
        }
    };

    public List<Articles> sortPriceDesc() {
        List<Articles> articles = loadArticles();
        articles.sort(artComparatorDesc);
        return articles;
    }

    public void updateName(int id, String name){
        List<Articles> articlesList = loadArticles();
        boolean found = false;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles article = articlesList.get(i);
            if (article.getId() == id) {
                article.setName(name);
                found = true;
                break;
            }
        }
        if (found) {
            save(articlesList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }

    public void updatePrice(int id, float price){
        List<Articles> articlesList = loadArticles();
        boolean found = false;

        for (int i = 0; i < articlesList.size(); i++) {
            Articles article = articlesList.get(i);
            if (article.getId() == id) {
                article.setPrice(price);
                found = true;
                break;
            }
        }
        if (found) {
            save(articlesList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }

    public void addOrderToArticle(Articles articles, Orders orders){
        articles.addOrders(orders);
    }

    public void removeOrdersFromArticles(Articles articles, Orders orderItem){
        articles.removeOrders(orderItem);
    }

}








