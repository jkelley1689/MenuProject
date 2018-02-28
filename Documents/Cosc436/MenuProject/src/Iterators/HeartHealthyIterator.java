package Iterators;

class HeartHealthyIterator implements MenuIterator{

    private int currentIndex;
    private Menu list;
    private String heartHealthy;
    private MenuItem validItem;

    public HeartHealthyIterator(Menu list,int startLoc,String heartHealthy){
        currentIndex = startLoc;
        this.list = list;
        this.heartHealthy = heartHealthy;
    }


    public boolean hasNext() {
        if(currentIndex < list.menuItems.length && list.menuItems[currentIndex] != null)
            return true;
        else
            return false;
    }


    public MenuItem nextItem() {
        if(hasNext() && list.menuItems[currentIndex].getHeartHealthy().equals(heartHealthy)) {
            validItem = list.menuItems[currentIndex];
            currentIndex++;
        } else if (hasNext()) {
            currentIndex++;
            nextItem();
        }
        return validItem;
    }
}
