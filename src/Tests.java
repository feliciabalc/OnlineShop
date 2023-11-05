import Controller.ArticlesController;
import Controller.ClientController;
import Controller.EmployeesController;
import Entities.Articles;
import Entities.Client;
import Entities.Employee;
import Entities.WorkersFactory;
import Repository.ArticlesRepo;
import Repository.ClientRepo;
import Repository.CourierRepo;
import Repository.EmployeesRepo;

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

   public void testFactory(){
       EmployeesRepo employeesRepo = new EmployeesRepo("EmployeesFile.json");
       CourierRepo courierRepo = new CourierRepo("CourierFile.json");
       WorkersFactory workersFactory = new WorkersFactory();
       EmployeesController employeesController = new EmployeesController(employeesRepo, courierRepo, workersFactory);

       employeesController.saveOneObject(10, "Ion", "13009", 12345.6789, "OrdersManagement");
       assert(employeesController.findById(10) != null);

       employeesController.saveOneObject(20, "Maria", "4500", 0789.3457, "Courier");
       assert(courierRepo.findById(20)!=null);

   }
}
