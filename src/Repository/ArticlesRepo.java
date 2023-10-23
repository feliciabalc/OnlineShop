package Repository;

import Entities.Articles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticlesRepo extends AbstractRepo {
    public ArticlesRepo(String fileName) {
        super(fileName);
    }




    public List<String> convertObjectsToStrings(List<?> objects) {
        List<String> data = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof Articles) {
                Articles article = (Articles) obj;
                String formattedArticle = String.format("%s,%s,%s,%s,%f",
                        article.getName(), article.getBrand(), article.getMaterial(),
                        article.getType(), article.getPrice());
                data.add(formattedArticle);
            }
        }
        return data;
    }






    //////ai ca parametru lista de articole, in abstract repo ai de string uri
    /*
    public void save(List<Articles> articles) throws IOException {
        List<String> data = new ArrayList<>();
        for (Articles article : articles) {
            String Articles = String.format("%s,%s,%s,%s,%f",
                    article.getName(), article.getBrand(), article.getMaterial(),
                    article.getType(), article.getPrice());
            data.add(Articles);
        }
        save(data);
    }

     */

    public void save(List<?> objects) throws IOException {
        super.save(objects);
    }



}
