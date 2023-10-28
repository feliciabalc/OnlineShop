package Repository;

import Entities.Articles;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class ArticlesRepo extends AbstractRepo {
    public ArticlesRepo(String fileName) {

        super(fileName);
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









}
