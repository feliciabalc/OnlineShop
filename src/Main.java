import UI.ShopUI;

public class Main {

    public static void main(String[] args) {
        ShopUI menu = new ShopUI();
        menu.startMenu();

        Tests t1 = new Tests();
        t1.testFillters();
        t1.testSortAsc();
        t1.testFactory();
        t1.testObserver();
        t1.testStrategy();

        //continua main
        //pune shopUi in while
        //fa ca in ui sa nu ai niciun repo
    }
}
