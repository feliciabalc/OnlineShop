import UI.ShopUI;

public class Main {

    public static void main(String[] args) {
        ShopUI menu = new ShopUI();
        menu.startMenu();

        Tests t1 = new Tests();
        t1.testFillters();
        t1.testSortAsc();
    }
}
