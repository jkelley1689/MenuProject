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

    //Iterator call functions
    public MenuIterator getAllItemsIterator(){
        return new AllItemsIterator(this,0);
    }

    public MenuIterator getItemIterator(String choice){
        return new ItemIterator(this,0,choice);
    }

    public MenuIterator getHeartHealthyIterator(){
        return new HeartHealthyIterator(this,0,"Heart healthy");
    }

    public MenuIterator getPriceIterator(String price){
        return new PriceIterator(this,0,price);
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
    //functions for removing an item from the array
    public boolean delete(MenuItem item){
        int itemIndex = getIndex(item);

        if(itemIndex == -1)
            return false;
        else
            deleteItem(itemIndex);
        return true;
    }

    private int getIndex(MenuItem item){
        if(item == null)
            throw new NullPointerException();
        else {
            for (int i = 0; i < itemCount; i++) {
                if(menuItems[i].equals(item))
                    return i;
            }
        }
        return -1;
    }
    private MenuItem[] deleteItem(int itemIndex){
        if(itemIndex < 0 || itemIndex > listCapacity)
            throw new ArrayIndexOutOfBoundsException(itemIndex);
        for(int i = itemIndex + 1;i<itemCount;i++){
            menuItems[i - 1] = menuItems[i];
        }
        return menuItems;
    }



}
