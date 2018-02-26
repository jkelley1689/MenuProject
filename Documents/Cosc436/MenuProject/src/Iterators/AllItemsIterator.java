package Iterators;

class AllItemsIterator implements MenuIterator{

    private int currentIndex;
    private Menu list;

    public AllItemsIterator(Menu list,int startIndex){
        currentIndex = startIndex;
        this.list = list;
    }


    public boolean hasNext() {
        if(currentIndex < list.menuItems.length && list.menuItems[currentIndex + 1] != null)
            return true;
        else
            return false;
    }


    public MenuItem nextItem() {
        currentIndex += 1;
        return list.menuItems[currentIndex];
    }
}
