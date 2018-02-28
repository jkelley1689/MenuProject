import Iterators.*;
import java.util.Scanner;


public class MenuMain {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem(new MenuItem("Lobster Dinner", Menu.MAIN, Menu.NOT_HEART_HEALTHY, "24.99"));
        menu.addItem(new MenuItem("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, "3.50"));
        menu.addItem(new MenuItem("Salad", Menu.MAIN, Menu.HEART_HEALTHY, "8.99"));
        menu.addItem(new MenuItem("Grilled Chicken", Menu.MAIN, Menu.HEART_HEALTHY, "10.99"));
        menu.addItem(new MenuItem("Bacon Cheeseburger", Menu.MAIN, Menu.NOT_HEART_HEALTHY, "12.99"));
        menu.addItem(new MenuItem("Hot wings", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, "7.99"));
        System.out.println();
        System.out.println("Welcome to Justin's");
        menuChoices(menu);
        //deleteOptions(menu);

    }

    public static void menuChoices(Menu menu){
        Scanner console = new Scanner(System.in);
        openingMenu();
        int choice = console.nextInt();
        while(choice != 9){
            switch (choice) {
                case 1:
                    MenuIterator allItr = menu.getAllItemsIterator();
                    System.out.println("All Items \n---------");
                    displayMenu(allItr);
                    break;
                case 2:
                    MenuIterator appItr = menu.getItemIterator("Appetizer");
                    System.out.println("All Appetizers \n--------------");
                    displayMenu(appItr);
                    break;
                case 3:
                    MenuIterator mainItr = menu.getItemIterator("Main");
                    System.out.println("All Main Dishes \n---------------");
                    displayMenu(mainItr);
                    break;
                case 4:
                    MenuIterator dessertItr = menu.getItemIterator("Dessert");
                    System.out.println("All Deserts \n-----------");
                    displayMenu(dessertItr);
                    break;
                case 5:
                    MenuIterator healthyItr = menu.getHeartHealthyIterator();
                    System.out.println("Heart Healthy Items \n-------------------");
                    displayMenu(healthyItr);
                    break;
                case 6:
                    System.out.println("What price point would you like to set?");
                    System.out.print(">>");
                    int price = console.nextInt();
                    String pp = Integer.toString(price);
                    MenuIterator priceItr = menu.getPriceIterator(pp);
                    System.out.println("Items under $" + pp + "\n------------------");
                    displayMenu(priceItr);
                    break;
                case 7:
                    System.out.println("Adding an Item");
                    System.out.println("Item Name: ");
                    System.out.print(">>");
                    String name = console.next();
                    System.out.println("Is this an Appetizer, Main, or Dessert");
                    System.out.println("Press 1 for Appetizer, 2 for Main, 3 for Dessert");
                    System.out.print(">>");
                    int type = console.nextInt();
                    System.out.println("Is this item heart healthy? True/False");
                    System.out.print(">>");
                    String health = console.next();
                    boolean result;
                    if (health.equalsIgnoreCase("true"))
                        result = Menu.HEART_HEALTHY;
                    else
                        result = Menu.NOT_HEART_HEALTHY;
                    System.out.println("Enter the price of the item");
                    System.out.print(">>");
                    double itemPrice = console.nextDouble();
                    menu.addItem(new MenuItem(name, type, result, Double.toString(itemPrice)));
                case 8:
                    System.out.println("Delete an Item");
                    deleteOptions(menu);
            }
            openingMenu();
            choice = console.nextInt();
        }
        System.out.println("Thanks for visiting!!");
    }

    public static void openingMenu(){
        System.out.println();
        System.out.println("Please choose one of the following \n");
        System.out.println("1. Display all Items");
        System.out.println("2. Display Appetizers");
        System.out.println("3. Display Main Dishes");
        System.out.println("4. Display Desserts");
        System.out.println("5. Display Heart Healthy Items");
        System.out.println("6. Display Items Under a Certain Price");
        System.out.println("7. Add an Item");
        System.out.println("8. Remove an Item");
        System.out.println("9. Exit");
        System.out.print(">>");
    }

    public static void displayMenu(MenuIterator itr) {
        MenuItem item;
        while (itr.hasNext()) {
            item = itr.nextItem();
            System.out.println(item.getItemName()
                    + ", " + item.getCategory()
                    + ", " + item.getHeartHealthy()
                    + ", $" + item.getPrice());
        }

    }

    public static void deleteOptions(Menu menu) {
        Scanner console = new Scanner(System.in);
        MenuIterator itr = menu.getAllItemsIterator();
        MenuItem item = null;
        String response = "";
        while(!response.equals("d")){
            if(itr.hasNext()) {
                item = itr.nextItem();
                System.out.println(item.getItemName()
                        + ", " + item.getCategory()
                        + ", " + item.getHeartHealthy()
                        + ", $" + item.getPrice());
            }
            System.out.println("Any key to continue, 'd' to delete");
            response = console.next();
            }
        menu.delete(item);
        }

    }





