package Controller;
import Entities.Articles;
import Repository.ArticlesRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArticlesController {
    private static ArticlesRepo articlesRepo;

    public ArticlesController(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }

    public ArticlesRepo getArticlesRepo() {
        return articlesRepo;
    }

    public void setArticlesRepo(ArticlesRepo articlesRepo) {
        this.articlesRepo = articlesRepo;
    }


    public static List<Articles> load() {
        return articlesRepo.loadArticles();
    }

    public static void save(List<Articles> articles) {
        articlesRepo.save(articles);
    }

    public List<Articles> findAll() {
        return articlesRepo.loadArticles();
    }

    public Articles findById(int Id) {

        return articlesRepo.findById(Id);
    }

    public void delete(int id) {
        articlesRepo.delete(id);
    }

    public void updateTheArticle(int id, Articles article) {
        articlesRepo.update(id, article);
    }


    public List<Articles> filteredByBrand(String brand) {
        List<Articles> articles = load();
        List<Articles> filteredArticles = new ArrayList<>();
        for (Articles item : articles) {
            if (item.getBrand() == brand)
                filteredArticles.add(item);
        }
        return filteredArticles;


    }

    public List<Articles> filteredByMaterial(String material) {
        List<Articles> articles = load();
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
        List<Articles> articles = load();
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
        List<Articles> articles = load();
        articles.sort(artComparatorDesc);
        return articles;
    }

    public void updateName(int id, String name){
        List<Articles> articlesList = load();
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
        List<Articles> articlesList = load();
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
    //pune add
}
