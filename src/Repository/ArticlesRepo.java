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
    private CartRepo cartRepo;
    private OrdersRepo ordersRepo;
    private WarehouseRepo warehouseRepo;

    public ArticlesRepo(String fileName, String ClientFile, String specificationFilename, String reviewFilename, String courierFile, String warehouseFile, String employeeFile, String cartFilename, String supplierFile, String orderFile) {

        super(fileName);
        this.specificationsRepo=new SpecificationsRepo(specificationFilename,ClientFile,fileName,reviewFilename,courierFile,warehouseFile,employeeFile,cartFilename,supplierFile,orderFile);
        this.reviewRepo = new ReviewRepo(reviewFilename,ClientFile,specificationFilename,fileName,courierFile,warehouseFile,employeeFile,cartFilename,supplierFile,orderFile);
        this.cartRepo=new CartRepo(cartFilename,ClientFile,specificationFilename,reviewFilename,courierFile,warehouseFile,employeeFile,fileName,supplierFile,orderFile);
        this.ordersRepo=new OrdersRepo(orderFile,ClientFile,fileName,specificationFilename,reviewFilename,courierFile,warehouseFile,employeeFile,cartFilename,supplierFile);
        this.warehouseRepo=new WarehouseRepo(warehouseFile, ClientFile,reviewFilename,specificationFilename,fileName,orderFile,courierFile,employeeFile,cartFilename,supplierFile);
    }


    @Override
    public void save(List objects) {
        super.save(objects);
    }




    public List<Articles> loadArticles() {
        Type articlesListType = new TypeToken<List<Articles>>() {}.getType();
        List<Articles> articles = load(articlesListType);
        for(Articles article : articles) {
            List<Specifications> specificationsList = article.getSpecifications();
            for(int i = 0; i< specificationsList.size(); i++) {
                Specifications specification = specificationsRepo.findById(specificationsList.get(i).getId());
                specificationsList.set(i, specification);
            }
            List<Review> reviewList = article.getReviews();
            for(int j=0; j<reviewList.size(); j++){
                Review review = reviewRepo.findById(reviewList.get(j).getId());
                reviewList.set(j,review);
            }
            List<Cart> cartList = article.getCart();
            if(cartList.size()!=0){
                for(int k=0; k<cartList.size();k++){
                    Cart cart= cartRepo.findById(cartList.get(k).getId());
                    cartList.set(k,cart);
                }}
            List<Orders> ordersList = article.getOrders();
            for(int l=0; l<ordersList.size();l++){
                Orders order = ordersRepo.findById(ordersList.get(l).getId());
                ordersList.set(l,order);
            }
            List<Warehouse> warehouseList = article.getWarehouse();
            for(int m=0; m<warehouseList.size();m++){
                Warehouse warehouse = warehouseRepo.findById(warehouseList.get(m).getId());
                warehouseList.set(m,warehouse);
            }
        }
        return articles;
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

    public void addCartToArticle(Articles article, int id){
        Cart cart = cartRepo.findById(id);
        if (cart != null) {
            article.addCart(cart);
            saveOneObject(article);}
    }

    public void removeCartToArticle(Articles article, int id){
        Cart cart = cartRepo.findById(id);
        article.removeCart(cart);
        saveOneObject(article);
    }

    public void addOrderToArticle(Articles article, int id){
        Orders order=ordersRepo.findById(id);
        article.addOrders(order);
        saveOneObject(article);
    }

    public void removeOrderToArticle(Articles article, int id){
        Orders order=ordersRepo.findById(id);
        article.removeOrders(order);
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

    public void addWarehouseToArticle(Articles article, int id){
        Warehouse warehouse=warehouseRepo.findById(id);
        article.addWarehouse(warehouse);
        saveOneObject(article);
    }

    public void removeWarehouseToArticle(Articles article, int id){
        Warehouse warehouse=warehouseRepo.findById(id);
        article.removeWarehouse(warehouse);
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

}








