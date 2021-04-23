package TestPuzzle;

import org.junit.Test;
import puzzle.Board;
import puzzle.Solver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolverTest {
    @Test
    public void testSover(){
        int arr[][] = {{0,2,3},{4,5,6},{7,1,8}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(s.moves());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }
    @Test
    public void testSolveable(){
        int arr[][] = {{0,1,3},{4,2,5},{7,8,6}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(s.moves());
        System.out.println(s.isSolvable());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }

    @Test
    public void testSolveablealready(){
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(b1.twin());
        System.out.println(s.moves());
        System.out.println(s.isSolvable());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }

    @Test
    public void testSolveableFour(){
        int arr[][] = {{5,1,2,4},{6,0,10,7},{13,11,3,8},{14,9,15,12}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(b1.twin());
        System.out.println(s.moves());
        System.out.println(s.isSolvable());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }

    @Test
    public void testSolveableTwele(){
        int arr[][] = {{1,2,3,4,5},{12,6,8,9,10},{0,7,13,19,14},{11,16,17,18,15},{21,22,23,24,20}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(b1.twin());
        System.out.println(s.moves());
        System.out.println(s.isSolvable());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }



    @Test
    public void testSolveableTen(){
        int arr[][] = {{0,4,1},{5,3,2},{7,8,6}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        System.out.println(s.moves());
        System.out.println(s.isSolvable());
        for(Board b:s.solution())
            System.out.println(b.toString());
    }


    @Test
    public void testUnSolveable(){
        int arr[][] = {{1,2,3},{4,5,6},{8,7,0}};
        Board b1 = new Board(arr);
        Solver s = new Solver(b1);
        assertEquals(s.solution(), null);
        assertEquals(s.isSolvable(), false);
        assertEquals(s.moves(), -1);
    }

    @Test
    public void testList(){
        int arr[][] = {{0,1,3},{4,2,5},{7,8,6}};
        int arr2[][] = {{0,1,3},{4,2,5},{7,8,6}};
        Board b1 = new Board(arr);
        Board b2 = new Board(arr2);
        List<Board> solutionLIst = new ArrayList<Board>();
        solutionLIst.add(b1);
        //solutionLIst.add(b2);
        System.out.println(solutionLIst.contains(b1));
        System.out.println(solutionLIst.contains(b2));
    }
}
