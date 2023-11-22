import DB_Repo.ArticleRepoDB;
import DB_Repo.CartRepoDB;
import Entities.*;
import Repository.CartRepo;
import Repository.ClientRepo;
import UI.ShopUI;
import UI.ShopUi_DB;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //ShopUI menu = new ShopUI();
        //menu.startMenu();

        ShopUi_DB menu = new ShopUi_DB();
        menu.startMenu();

        Tests t1 = new Tests();
        t1.testLoad_db();
        t1.testUpdate_find();;

        String connectionString = "jdbc:mysql://localhost:3306/onlineshop";
        String username = "shop_user";
        String password = "shop_pass";


        //pattern

    }
}
