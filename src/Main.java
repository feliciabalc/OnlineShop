import DB_Repo.ArticleRepoDB;
import Entities.*;
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
        //Articles articles = new Articles(2,"tricou", "cx", "bumbac", "maneca", 2);



        Specifications specification = new Specifications(1, new String[]{"S", "M"}, "blue", 26, true);
        System.out.println(specification.getAvailability());
        //articles.addSpecifications(specification);

       // articlesList.add(articles);

        String jdbcUrl = "jdbc:mysql://localhost:3306/onlineshop";
        String username = "shop_user";
        String password = "shop_pass";

       // ArticleRepoDB articleRepoDB = new ArticleRepoDB(jdbcUrl, username, password);
        //System.out.println(articleRepoDB.loadFromDB());


        //continua main
        ///  public void addOrderToArticle(Articles articles, int specId) {
        //          il adaug in saveIntoDB, dupa ca sail iau il caut in tabelu lui
        //        articles.addOrders(order);
        //trebe si un controller articlesOrder

    }
}
