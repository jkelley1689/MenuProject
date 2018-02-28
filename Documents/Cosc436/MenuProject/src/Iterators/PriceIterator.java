package Iterators;

public class PriceIterator implements MenuIterator{


    private int currentIndex;
    private Menu list;
    private String pricePoint;
    private MenuItem validItem;

    public PriceIterator(Menu list, int startLoc,String pricePoint){
        currentIndex = startLoc;
        this.list = list;
        this.pricePoint = pricePoint;
    }


    public boolean hasNext() {
        if(currentIndex < list.menuItems.length && list.menuItems[currentIndex] != null)
            return true;
        else
            return false;
    }


    public MenuItem nextItem() {
        if(hasNext() && Double.parseDouble(list.menuItems[currentIndex].getPrice()) < Double.parseDouble(pricePoint)){
            validItem = list.menuItems[currentIndex];
            currentIndex++;
        }
        else {
            currentIndex++;
            nextItem();
        }
        return validItem;

    }
}
