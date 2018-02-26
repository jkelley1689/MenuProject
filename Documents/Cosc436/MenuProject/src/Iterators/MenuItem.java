package Iterators;

public class MenuItem {

    private String itemName;
    private int category;
    private boolean heartHealthy;
    private String price;

    public MenuItem(String itemName,int category,boolean heartHealthy,String price){
        this.itemName = itemName;
        this.category = category;
        this.heartHealthy = heartHealthy;
        this.price = price;
    }

    public String getItemName(){
        return itemName;
    }
    public String getCategory(){
        if(category == 1)
            return "Appetizer";
        else if(category == 2)
            return "Dinner";
        else
            return "Dessert";
    }
    public String getHeartHealthy(){
        if(heartHealthy == true)
            return "Heart healthy";
        else
            return "Not heart healthy";
    }
    public String getPrice(){
        return price;
    }
}
