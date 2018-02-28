package Iterators;

class AllItemsIterator implements MenuIterator{

    private int currentIndex;
    private Menu list;
    private MenuItem item;

    public AllItemsIterator(Menu list,int startIndex){
        currentIndex = startIndex;
        this.list = list;
    }


    public boolean hasNext() {
        if(currentIndex < list.menuItems.length && list.menuItems[currentIndex] != null)
            return true;
        else
            return false;
    }


    public MenuItem nextItem() {
        item = list.menuItems[currentIndex];
        currentIndex += 1;
        return item;
    }
}
