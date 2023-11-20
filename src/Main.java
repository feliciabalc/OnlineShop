import DB_Repo.ArticleRepoDB;
import Entities.Articles;
import Entities.Cart;
import Entities.Client;
import Repository.CartRepo;
import Repository.ClientRepo;
import UI.ShopUI;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //ShopUI menu = new ShopUI();
        //menu.startMenu();






        Tests t1 = new Tests();
        t1.testFillters();
        t1.testSortAsc();
        t1.testFactory();
        t1.testObserver();
        t1.testStrategy();


        List<Articles> articlesList = new ArrayList<>();
        Articles articles = new Articles(10, "rochie", "zara", "tafta", "lunga", 156);
        articlesList.add(articles);

        String jdbcUrl = "jdbc:mysql://localhost:3306/onlineshop";
        String username = "shop_user";
        String password = "shop_pass";

        ArticleRepoDB articleRepoDB = new ArticleRepoDB(jdbcUrl, username, password);
        //articleRepoDB.saveIntoDB(articlesList);
        System.out.println(articleRepoDB.loadFromDB(articlesList));


        //continua main

    }
}
