import Entities.Articles;
import Repository.ArticlesRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Articles a1  = new Articles("bluza", "cx", "bumbac", "maneca", 24, null, null, null, null, null);
        Articles a2 = new Articles("pant", "cx", "bumbac", "maneca", 29, null, null, null, null, null);

        ArticlesRepo r1 = new ArticlesRepo("ArticlesFile.json");

        List<Articles> articlesList = new ArrayList<>();
        articlesList.add(a1);
        articlesList.add(a2);


        r1.save(articlesList);

    }
}