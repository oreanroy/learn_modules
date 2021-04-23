package puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {

    private int moves = 0;
    private boolean solveable  = false;
    private Stack<Board> solutionLIst;
    //private List<Board> uptillNow = new ArrayList<Board>();
    private MinPQ<bordRep> pq = new MinPQ();
    private int NumberOfMoves = 0;
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


    public Solver(Board initial){
        if(initial == null)
            throw new IllegalArgumentException();
        solutionLIst = new Stack<>();
        solve(initial);
    }


    private boolean solve(Board initial){
        MinPQ<bordRep> pq2 = new MinPQ();
        bordRep present_one = new bordRep(initial, 0, null);
        bordRep present_twin = new bordRep(initial.twin(), 0, null);
        pq.insert(present_one);
        pq.insert(present_twin);
        boolean flag_one = false;
        while (!pq.isEmpty()){
            present_one = pq.delMin();
            if(present_one.b.hamming()==0)
            {
                flag_one = true;
                break;
            }
            Iterable<Board> neighbours_one =  present_one.b.neighbors();
            for(Board b: neighbours_one){
                if( (present_one.prev!=null && !present_one.prev.b.equals(b)) || present_one.prev==null)
                {    pq.insert(new bordRep(b, present_one.moves+1, present_one));
                //uptillNow.add(b);
                    }
            }

            if(flag_one)
                break;
        }
            NumberOfMoves=present_one.moves;
            bordRep temp = present_one;
            while (temp.prev!=null){
                solutionLIst.push(temp.b);
                temp = temp.prev;
            }

            if(temp.b.equals(initial)){
                solutionLIst.push(temp.b);
                solveable=true;
                return true;
            }

        return false;
    }


    // is the initial board solvable? (see below)
    public boolean isSolvable(){
        return solveable;
    }


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