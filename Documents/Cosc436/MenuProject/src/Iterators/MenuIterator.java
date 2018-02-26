package Iterators;

public interface MenuIterator {
    //returns true if there are items of the appropriate type left in the list
     boolean hasNext();
     //returns current item and advances to the next item
     MenuItem nextItem();
}
