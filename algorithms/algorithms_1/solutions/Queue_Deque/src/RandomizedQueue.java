import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int count;
    private int last;
    private Item[] s;

    // construct an empty randomized queue
    public RandomizedQueue(){

        count=0;
        last = 0;
        s = (Item[]) new Object[1];
    }


    // is the randomized queue empty?
    public boolean isEmpty(){
        return count==0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return count;
    }

    // add the item
    public void enqueue(Item item){
        if(item==null)
            throw new IllegalArgumentException();
        if(last==s.length/2)
            resize(s.length*2);
        s[last++]=item;
        count++;
    }

    // remove and return a random item
    public Item dequeue(){
        if(count==0)
            throw new NoSuchElementException();
        int randomInt = StdRandom.uniform(count);
        Item item = s[randomInt];
        s[randomInt] = s[--last];
        s[last] = null;
        if(last==s.length/4)
            resize(s.length/2);
        count--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(count==0)
            throw new NoSuchElementException();
        int randomPoninter = StdRandom.uniform(count);
        return s[randomPoninter];
    }

    private void resize(int size){
         Item[] newArray = (Item[]) new Object[size];
         for(int i=0;i<count;i++){
             newArray[i]=s[i];
         }
         s=newArray;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new randomIterator();
    }
    private class randomIterator implements Iterator<Item> {
        private int range = count;
        public boolean hasNext() { return range > 0;}
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if(count==0)
                throw new NoSuchElementException();
            int randomPoninter = StdRandom.uniform(range);
            Item item = s[randomPoninter];
            s[randomPoninter] = s[--range];
            s[range] = item;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args){

    }

}