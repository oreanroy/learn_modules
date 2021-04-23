package puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solver_copy_60 {

    private int moves = 0;
    private boolean solveable  = false;
    private Stack<Board> solutionLIst;
    private List<Board> uptillNow = new ArrayList<Board>();
    private MinPQ<bordRep> pq = new MinPQ();
    private int NumberOfMoves = 0;
    private Board b_main;
    // find a solution to the initial board (using the A* algorithm)

    private class bordRep implements Comparable<bordRep>{
        Board b;
        int hamming;
        int mamhatan;
        int moves;
        bordRep prev;
        public bordRep(Board b, int moves, bordRep prev){
            this.b = b;
            this.hamming = b.hamming();
            this.mamhatan = b.manhattan();
            this.moves = moves;
            this.prev = prev;
        }

        public int compareTo(bordRep bsecond){
            if(mamhatan+moves  < bsecond.mamhatan+bsecond.moves )
                return -1;
            else if(mamhatan+moves  > bsecond.mamhatan+bsecond.moves )
                return 1;
            else if(mamhatan < bsecond.mamhatan)
                return -1;
            else if(mamhatan > bsecond.mamhatan)
                return 1;
            else
                return 0;
        }

    }

    /*
    private class bordRep implements Comparator<bordRep> {
        Board b;
        int hamming;
        int mamhatan;
        public bordRep(Board b){
            this.b = b;
            this.hamming = b.hamming();
            this.mamhatan = b.manhattan();
        }

        public int compare(bordRep bfirst, bordRep bsecond){
            if(bfirst.mamhatan  < bsecond.mamhatan )
                return -1;
            else if(bfirst.mamhatan  > bsecond.mamhatan )
                return 1;
            else if(bfirst.hamming < bsecond.hamming)
                return -1;
            else if(bfirst.hamming > bsecond.hamming)
                return 1;
            else
                return 0;
        }

    } */

    public Solver_copy_60(Board initial){
        if(initial == null)
            throw new IllegalArgumentException();
        b_main = initial;
        solutionLIst = new Stack<>();
        solve(initial);
        if(!isSolvable())
            return;

    }


    private boolean solve(Board initial){
        MinPQ<bordRep> pq2 = new MinPQ();
        List<Board> uptillNow_two = new ArrayList<Board>();

        bordRep present_one = new bordRep(initial, 0, null);
        bordRep present_twin = new bordRep(initial.twin(), 0, null);
        //pq.insert(null);
        pq.insert(present_one);
        //pq2.insert(null);
        pq2.insert(present_twin);
        boolean flag_one = false;
        boolean flag_two = false;
        while (!pq.isEmpty()){
            present_one = pq.delMin();
            present_twin = pq2.delMin();
            //NumberOfMoves++;
            //solutionLIst.push(present_one.b);
            if(present_one.b.hamming()==0)
            {
                flag_one = true;
                solveable=true;
                break;
            }
            if(present_twin.b.hamming()==0)
            {
                flag_one = false;
                solveable=false;
                break;
            }
            Iterable<Board> neighbours_one =  present_one.b.neighbors();
            Iterable<Board> neighbours_two =  present_twin.b.neighbors();
            for(Board b: neighbours_one){
               /* if(b.hamming()==0)
                {//NumberOfMoves++;
                    solutionLIst.add(b);
                    flag_one = true;
                    solveable=true;
                    break;
                } */
                if(!uptillNow.contains(b))
                {    pq.insert(new bordRep(b, present_one.moves+1, present_one));
                uptillNow.add(b); }
            }
            for(Board b: neighbours_two){
                if(b.hamming()==0)
                {
                    flag_two = true;
                    break;
                }
                if(!uptillNow_two.contains(b))
                {  pq2.insert(new bordRep(b, present_twin.moves+1, present_twin));
                uptillNow_two.add(b); }
            }

            if(flag_one || flag_two)
                break;
        }
        if(flag_one)
        {
            NumberOfMoves=present_one.moves;
            bordRep temp = present_one;
            while (temp!=null){
                solutionLIst.push(temp.b);
                temp = temp.prev;
            }
        return true;
        }
        return false;
    }


    // is the initial board solvable? (see below)
    public boolean isSolvable(){
        return solveable;
    }


/*    private boolean checkSolveable(){
        int n = b_main.dimension();
        int inversionCount = 0;
        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(b_main.board_state[i][j]==0)
                    continue;
                else{
                    for (int l=i; l<n; l++){
                        int m = 0;
                        if(i==l)
                            m=j;
                        else
                            m=0;
                        while (m<n){
                            if(b_main.board_state[l][m]==0)
                            {m++;continue;}
                            else if(b_main.board_state[l][m]<b_main.board_state[i][j])
                                inversionCount++;
                            m++;
                        }
                    }
                }
            }
        }
        return inversionCount%2==0;
    }
*/

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){
        if(!solveable)
            return -1;
        return NumberOfMoves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
        if(!solveable)
            return null;
        return solutionLIst;
    }

    // test client (see below)
    public static void main(String[] args){

    }

}