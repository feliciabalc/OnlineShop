import Controller.ArticlesController;
import Entities.*;
import Repository.ArticlesRepo;
import Repository.ClientRepo;
import UI.ArticlesUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public void startMenu(){
        System.out.println("Choose your ");
    }



    public static void main(String[] args) throws IOException {
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24, null, null, null, null, null);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 29, null, null, null, null, null);
        Articles a3 = new Articles(5,"top", "nike", "tafta", "maneca", 35, null, null, null, null, null);
        Articles a4 = new Articles(6,"pantaloni", "nike", "elastan","scurti", 100,null,null,null,null,null);

        ArticlesRepo r1 = new ArticlesRepo("ArticlesFile.json");
        ArticlesController articlesController=new ArticlesController(r1);
        List<Articles> articlesList = new ArrayList<>();
        articlesList.add(a1);
        articlesList.add(a2);
        articlesList.add(a3);
        ArticlesUI articlesUI = new ArticlesUI(articlesController);


    Cart cart1= new(1,20, null, null)




        Client c1 = new Client(1,"Ana", "Horea", 0752.343786, null, null, null);
        Client c2 = new Client(5,"Matei", "Gruia", 07524.43786, null, null, null);

        ClientRepo r2 = new ClientRepo("ClientFile.json");
        List<Client> clientsList = new ArrayList<>();
        clientsList.add(c1);
        clientsList.add(c2);

       r2.save(clientsList);
        System.out.println(r2.loadClient());

        r1.save(articlesList);
        System.out.println(r1.loadArticles());

        System.out.println(r1.findAll());

        ArticlesController ac = new ArticlesController(r1);

        r1.delete(1);
        r1.update(2,a4);

    }
}