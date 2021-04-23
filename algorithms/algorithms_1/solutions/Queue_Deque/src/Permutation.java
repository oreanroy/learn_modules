import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){
        RandomizedQueue ran = new RandomizedQueue();
        int k = Integer.parseInt(args[0]);

        while(!StdIn.isEmpty()){
            String nextInput= StdIn.readString();
            ran.enqueue(nextInput);
        }
        while (k>0){
            Object permutationString = ran.dequeue();
            System.out.println(permutationString);
            k--;
        }

    }
}