import java.util.Iterator;

public class RandomizedQueue3<Item> implements Iterable<Item> {

    private int count;
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    // construct an empty randomized queue
    public RandomizedQueue3(){
        first = null;
    }


    // is the randomized queue empty?
    public boolean isEmpty(){
        return first==null;
    }

    // return the number of items on the randomized queue
    public int size(){
        return count;
    }

    // add the item
    public void enqueue(Item item){
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = first;
        first = newFirst;
    }

    // remove and return a random item
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        return first.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new randomIterator();
    }
    private class randomIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null;}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){

    }

}