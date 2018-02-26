import Iterators.*;


public class MenuMain {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Lobster Dinner",Menu.MAIN,Menu.NOT_HEART_HEALTHY,"24.99"));
        menu.addItem(new MenuItem("Rice Pudding",Menu.DESSERT,Menu.NOT_HEART_HEALTHY,"3.50"));
        menu.addItem(new MenuItem("Salad",Menu.MAIN,Menu.HEART_HEALTHY,"8.99"));

        MenuIterator allItr = menu.getAllItemsIterator();
        displayMenu(allItr);

        MenuIterator itemItr = menu.getItemIterator();
        displayMenu(itemItr);

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
