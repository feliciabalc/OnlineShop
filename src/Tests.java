import Controller.ArticlesController;
import Controller.ClientController;
import Entities.Articles;
import Entities.Client;
import Repository.ArticlesRepo;
import Repository.ClientRepo;

import java.util.List;

public class Tests {

   public void testSortAsc(){
       ArticlesRepo articlesRepo = new ArticlesRepo("ArticlesFile.json");
       ArticlesController ac = new ArticlesController(articlesRepo);
       List<Articles> sortedArticles=ac.sortPriceAsc();

       assert(sortedArticles.get(0).getPrice()==100);
   }


   public void testFillters(){
       ClientRepo clientRepo = new ClientRepo("ClientFile.json");
       ClientController cc = new ClientController(clientRepo);
       List<Client> fillteredClients = cc.filteredByName("Mark");

       assert(fillteredClients.size() == 2);
   }
}
