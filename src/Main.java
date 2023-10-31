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




    ////////////////ai ramas la orders, trebuie modificata metoda save one obj, adaugat obiectele cu care are legaturi in controller, plus metoda delete one obj,



    public static void main(String[] args) throws IOException {
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 2);
        Articles a3 = new Articles(5,"top", "nike", "tafta", "maneca", 35);
        Articles a4 = new Articles(6,"pantaloni", "nike", "elastan","scurti", 100);

        ArticlesRepo r1 = new ArticlesRepo("ArticlesFile.json");
        List<Articles> articlesList = new ArrayList<>();
        articlesList.add(a1);
        articlesList.add(a2);
        articlesList.add(a3);
        r1.save(articlesList);
        r1.saveOneObject(a4);






        Client c1 = new Client(1,"Ana", "Horea", 0752.343786, null, null, null);
        Client c2 = new Client(5,"Matei", "Gruia", 07524.43786, null, null, null);

        ClientRepo r2 = new ClientRepo("ClientFile.json");
        List<Client> clientsList = new ArrayList<>();
        clientsList.add(c1);
        clientsList.add(c2);

       r2.save(clientsList);
        System.out.println(r2.loadClient());



        ArticlesController ac = new ArticlesController(r1);



    }
}