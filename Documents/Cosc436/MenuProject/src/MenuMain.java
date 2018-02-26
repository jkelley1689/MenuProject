import Iterators.*;


public class MenuMain {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Lobster Dinner",Menu.MAIN,Menu.NOT_HEART_HEALTHY,"24.99"));
        menu.addItem(new MenuItem("Rice Pudding",Menu.DESSERT,Menu.NOT_HEART_HEALTHY,"3.50"));
        menu.printMenu();


    }
}
