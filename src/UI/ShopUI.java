package UI;
import java.util.Scanner;

public class ShopUI {
    private ArticlesUI articlesUI;
    private CartUI cartUI;
    private ClientUI clientUI;
    private CourierUI courierUI;
    private EmployeeUI employeeUI;
    private OrdersUI ordersUI;
    private ReviewUI reviewUI;
    private SpecificationsUI specificationsUI;
    private SuppliersUI suppliersUI;
    private WarehouseUI warehouseUI;



    ////fa obiecte, salveaza le cu ui.save,

    public void startMenu(){
            System.out.println("Welcome to our shop!");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter your choice: 1. Manager. 2. Client. 3. Quit");


            int input = Integer.parseInt(myObj.nextLine());  // Read user input
            if(input==1)
                managerMenu();
            else if (input==2) {
                clientMenu();

            } else if (input==3) {
                System.out.println("Exiting...");
                //break;
            }
            System.out.println("Invalid choice!");
        }

        public void managerMenu(){
            System.out.println("Manager Menu");
            System.out.println("1.See all employees");
            System.out.println("2.See all suppliers");
            System.out.println("3.See all couriers");
            System.out.println("4. Add article");
            System.out.println("5.Add employee");
            System.out.println("6.Add courier");
            System.out.println("7.Add supplier");
            System.out.println("8.Remove employee");
            System.out.println("9.Remove supplier");
            System.out.println("10.Remove courier");
            //update, sort...

            Scanner myObj = new Scanner(System.in);
            int input2 = Integer.parseInt(myObj.nextLine());
            if(input2==1){
                employeeUI.findAll();
            }else if(input2==2){
                suppliersUI.findAll();
            }else if(input2==3){
                courierUI.findAll();
            }else if(input2==4){

            }
        }

        public void clientMenu(){

        }



    }
