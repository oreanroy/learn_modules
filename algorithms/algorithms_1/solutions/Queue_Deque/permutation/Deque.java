import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int count;

    private class Node{
        Item item;
        Node next;
        Node prev;
    }
    // construct an empty deque
    public Deque(){
        first=null;
        last=null;
        count=0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first==null;
    }

    // return the number of items on the deque
    public int size(){
        return count;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item==null)
            throw new IllegalArgumentException();
        count++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(oldFirst==null) {
            first.prev = null;
            last = first;
        }else{
            first.prev = null;
            oldFirst.prev = first;
        }
    }

    // add the item to the back
    public void addLast(Item item){
        if(item==null)
            throw new IllegalArgumentException();
        count++;
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(oldLast==null)
        {
            last.prev = null;
            first = last;
        }
        else
        {
            oldLast.next = last;
            last.prev = oldLast;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(first==null)
            throw new NoSuchElementException();
        count--;
        Node newFisrt = first.next;
        Item item = first.item;
        if(newFisrt==null)
        {last=newFisrt;
            first=newFisrt;}
        else{
            newFisrt.prev = null;
            first=newFisrt;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(first==null)
            throw new NoSuchElementException();
        count--;
        Node newLast = last.prev;
        Item item = last.item;
        if(newLast == null)
        {first = newLast;
        last=first;}
        else{
            newLast.next = null;
            last = newLast;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new queqeIterator();
    }

    private class queqeIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext() { return current != null;}
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if(first==null)
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){

    }

}