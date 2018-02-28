package Iterators;

class ItemIterator implements MenuIterator{

    private int currentIndex;
    private Menu list;
    private String itemCategory;
    private MenuItem validItem;

    public ItemIterator(Menu list, int startIndex,String itemCategory){
        currentIndex = startIndex;
        this.list = list;
        this.itemCategory = itemCategory;
    }

    public boolean hasNext() {
        if(currentIndex < list.menuItems.length && list.menuItems[currentIndex] != null)
            return true;
        else
            return false;
    }


    public MenuItem nextItem() {
        if (hasNext() && list.menuItems[currentIndex].getCategory().equals(itemCategory)) {
            validItem = list.menuItems[currentIndex];
            currentIndex++;
        } else if (hasNext()) {
            currentIndex++;
            nextItem();
        }
        return validItem;
    }




}

