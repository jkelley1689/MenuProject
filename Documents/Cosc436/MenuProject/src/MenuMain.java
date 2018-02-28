import Iterators.*;


public class MenuMain {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Lobster Dinner",Menu.MAIN,Menu.NOT_HEART_HEALTHY,"24.99"));
        menu.addItem(new MenuItem("Rice Pudding",Menu.DESSERT,Menu.NOT_HEART_HEALTHY,"3.50"));
        menu.addItem(new MenuItem("Salad",Menu.MAIN,Menu.HEART_HEALTHY,"8.99"));
        menu.addItem(new MenuItem("Grilled Chicken",Menu.MAIN,Menu.HEART_HEALTHY,"10.99"));
        menu.addItem(new MenuItem("Bacon Cheeseburger",Menu.MAIN,Menu.NOT_HEART_HEALTHY,"12.99"));
        menu.addItem(new MenuItem("Hot wings",Menu.APPETIZERS,Menu.NOT_HEART_HEALTHY,"7.99"));

        System.out.println("All Menu Items");
        MenuIterator allItr = menu.getAllItemsIterator();
        displayMenu(allItr);
        System.out.println();

        System.out.println("All items of chosen type");
        MenuIterator itemItr = menu.getItemIterator();
        displayMenu(itemItr);
        System.out.println();

        System.out.println("Heart healthy items");
        MenuIterator healthItr = menu.getHeartHealthyIterator();
        displayMenu(healthItr);
        System.out.println();

        System.out.println("All items under chosen price");
        MenuIterator priceItr = menu.getPriceIterator();
        displayMenu(priceItr);
        System.out.println("*******************");

        //menu.printMenu();


    }

    public static void displayMenu(MenuIterator itr){
        MenuItem item;
        while(itr.hasNext()){
            item = itr.nextItem();
            System.out.println(item.getItemName()
                    + ", " + item.getCategory()
                    + ", " + item.getHeartHealthy()
                    + ", $" + item.getPrice());
        }

    }
}
