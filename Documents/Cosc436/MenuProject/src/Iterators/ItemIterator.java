package Iterators;

class ItemIterator implements MenuIterator{

    private int currentIndex;
    private Menu list;
    private String itemCategory;
    private MenuItem validCategory;

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
        if (list.menuItems[currentIndex].getCategory().equals(itemCategory)) {
            validCategory = list.menuItems[currentIndex];
            currentIndex++;
        } else if (hasNext()) {
            currentIndex++;
            nextItem();
        }
        return validCategory;
    }




}

