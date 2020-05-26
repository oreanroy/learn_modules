/*
   api
   insert
   isEmpty
   getSize
   getMax
 
 */

/*
   helper functions
   exchange
   less
   swim
   sunk

*/

public class heapSort<Key extends Comparable<key>>{
    
    private Key[] pq;
    private int N;

    public heapSort(int capacity){
        pq = new Comparable[capacity+1];
        N=0;
    }

    public void insert(Key key){
        pq[N++] = key;
        swim(N);
    }

    public boolean isEmpty(){
        return N<=0;
    }

    public getSize(){
        return N;
    }

    public Key getMax(){
        Key max = pq[1];
        pq[1] = pq[N];
        sink(1);
        pq[N--] = null;
        return max;
    }

    private exchange(int i, int j){
        key temp = pq[j];
        pq[j] = pq[i];
        pq[i] = temp;
    }

    private less(int i, int  j){
        return pq[i].compareTo(pq[j]) <0;
    }

    private swim(int k){
        while(k>1){
            if(less(k/2, k){
                    exchange(k/2, k);
                    k = k/2;
            }
            else
                break;
        }
    }

    private sunk(int k){
        while(k<N){
            int j = 2*k;
            if(j<N && less(j, j++)) j++;
            if(!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }
}



