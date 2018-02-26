package Iterators;

public class Menu {
    MenuItem[] menuItems; //not allowed to use arrayList, implementing my own arrayList style functions

    public static final int APPETIZERS = 1;
    public static final int MAIN = 2;
    public static final int DESSERT = 3;

    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;

    private int itemCount = 0;
    private int listCapacity = 1;

    public Menu(){
        menuItems = new MenuItem[listCapacity]; //creates a new array of object MenuItem of size 1.
    }

    public boolean addItem(MenuItem item){
        if(item == null)
            throw new NullPointerException(); //checks that an object was actually passed to the function
        if(itemCount == listCapacity)
            reallocate(); //if array is full reallocate

        menuItems[itemCount] = item; //append the item to the end of the list
        itemCount++;

        return true;
    }

    private void reallocate(){  //if the array is full reallocate() is used. A temp array is created with a doubled capacity
        listCapacity *= 2;      //the items are reallocated to the temp array and the original array becomes the temp array
        MenuItem[] tempList = new MenuItem[listCapacity];
        for(int i = 0;i<itemCount;i++){
            tempList[i] = menuItems[i];
        }
        menuItems = tempList;
    }
    //test function for printing the menu....not what I want to use for real
    public void printMenu(){
        for(int i = 0;i<itemCount;i++){
            System.out.println(menuItems[i].getItemName()
            + ", " + menuItems[i].getCategory()
            + ", " + menuItems[i].getHeartHealthy()
            + ", $" + menuItems[i].getPrice());
        }
    }


}
