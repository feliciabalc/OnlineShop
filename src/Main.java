import Entities.Articles;
import Entities.Cart;
import Entities.Client;
import Repository.ArticlesRepo;
import Repository.ClientRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24, null, null, null, null, null);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 29, null, null, null, null, null);
        Articles a3 = new Articles(5,"top", "nike", "tafta", "maneca", 35, null, null, null, null, null);

        ArticlesRepo r1 = new ArticlesRepo("ArticlesFile.json");

        List<Articles> articlesList = new ArrayList<>();
        articlesList.add(a1);
        articlesList.add(a2);
        articlesList.add(a3);

        Client c1 = new Client(1,"Ana", "Horea", 0752.343786, null, null, null);
        Client c2 = new Client(5,"Matei", "Gruia", 07524.43786, null, null, null);

        ClientRepo r2 = new ClientRepo("ClientFile.json");
        List<Client> clientsList = new ArrayList<>();
        clientsList.add(c1);
        clientsList.add(c2);

       // r2.save(clientsList);
        //System.out.println(r2.load());

        r1.save(articlesList);
        System.out.println(r1.loadArticles());

        System.out.println(r1.findAll());

        r1.delete(1);

    }
}