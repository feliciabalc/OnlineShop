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
        //ne trebe meoda de a plasa comanda
        //intreaba-l pe bogdan daca sa lasam crearea obiectelor in controller sau in main
        //pune shopUi in while
        //fa in main sa ii dai un id si sa mearga in repo sa ia orderul cu id ul respectiv ca parametru pt singleton
        //intreaba-l pe bogdan daca orders trb sa ia ca obiect interfata sau pot si clientOrderObserver
    }
}
