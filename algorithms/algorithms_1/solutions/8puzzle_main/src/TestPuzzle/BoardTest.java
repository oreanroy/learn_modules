package TestPuzzle;

import org.junit.Test;
import puzzle.Board;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testToString(){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        Board b1 = new Board(arr);
        System.out.println(b1.toString());
        System.out.println("second !! \n");
        int arr2[][] = {{1,2,3},{4,0,6},{7,8,9}};
        Board b2 = new Board(arr);
        System.out.println(b2.toString());
    }

    /*@Test
    public void testgetPosition(){
        int arr[][] = {{1,2,3},{4,5,6},{7,0,9}};
        Board b1 = new Board(arr);
        Board.pos p = b1.getPosition(0);
            System.out.println("("+p.x+","+p.y+")");

    } */

    @Test
    public void testTwin(){
        int arr[][] = {{1,2,3},{4,5,6},{7,0,9}};
        Board b1 = new Board(arr);
        System.out.println(b1.twin().toString());
    }

    @Test
    public void testTwinZeroStart(){
        int arr[][] = {{0,2,3},{4,5,6},{7,1,9}};
        Board b1 = new Board(arr);
        System.out.println(b1.twin().toString());
    }
    @Test
    public void testTwinZeroSecond(){
        int arr[][] = {{2,0,3},{4,5,6},{7,1,9}};
        Board b1 = new Board(arr);
        System.out.println(b1.twin().toString());
    }


    @Test
    public void testNeighbours(){
        int arr[][] = {{1,2,3},{4,5,6},{7,0,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }
    @Test
    public void testNeighboursZero(){
        int arr[][] = {{0,2,3},{4,5,6},{7,1,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }

    @Test
    public void testNeighboursZeroLast(){
        int arr[][] = {{8,2,3},{4,5,6},{7,1,0}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }
    @Test
    public void testNeighboursZeroStart(){
        int arr[][] = {{0,2,3},{4,5,6},{7,1,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }

    @Test
    public void testNeighboursZeroAtN(){
        int arr[][] = {{1,2,0},{4,5,6},{7,3,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }

    @Test
    public void testNeighboursZeroAtXN(){
        int arr[][] = {{1,2,3},{4,5,6},{0,7,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }
    @Test
    public void testNeighboursThreZeroAtTop(){
        int arr[][] = {{1,0,3},{4,5,6},{2,7,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }


    @Test
    public void testNeighboursThreZeroAtSide(){
        int arr[][] = {{1,2,3},{0,5,6},{4,7,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }

    @Test
    public void testNeighboursThreZeroAtRightSide(){
        int arr[][] = {{1,2,3},{6,5,0},{4,7,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }

    @Test
    public void testNeighboursThreZeroAtBottom(){
        int arr[][] = {{1,2,3},{6,5,7},{4,0,8}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }


    @Test
    public void testNeighbours4(){
        int arr[][] = {{8,2,3},{4,0,6},{7,1,5}};
        Board b1 = new Board(arr);
        for(Board b: b1.neighbors())
            System.out.println(b.toString());
    }
    @Test
    public void testEquals(){
        int arr[][] = {{0,2,3},{4,5,6},{7,1,8}};
        int arr2[][] = {{0,2,3},{4,5,6},{7,1,8}};
        int arr3[][] = {{0,2,3},{4,5,6},{7,1,5}};
        Board b1 = new Board(arr);
        Board b2 = new Board(arr2);
        Board b3 = new Board(arr3);
        assertTrue(b1.equals(b2));
        assertTrue(b2.equals(b1));
        assertFalse(b1.equals(b3));
        assertFalse(b3.equals(b1));
    }

    @Test
    public void testhamming(){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,0}};
        Board b1 = new Board(arr);
        assertEquals(b1.hamming(), 0);
    }

    @Test
    public void testhammingTwo(){
        int arr[][] = {{0,1,3},{4,2,5},{7,8,6}};
        Board b1 = new Board(arr);
        System.out.println(b1.hamming());
    }

    @Test
    public void testManhatan(){
        int arr[][] = {{8,5,7},{1,4,6},{3,0,2}};
        Board b1 = new Board(arr);
        System.out.println(b1.manhattan());

        assertEquals(b1.manhattan(), 17);
    }
    @Test
    public void testManhatanTwo(){
        int arr[][] = {{8,1,3},{4,0,2},{7,6,5}};
        Board b1 = new Board(arr);
        System.out.println(b1.manhattan());
    }

    @Test
    public void testManhatanZero(){
        int arr[][] = {{1,2,3},{4,5,6},{7,8,0}};
        Board b1 = new Board(arr);
        assertEquals(b1.hamming(), 0);
    }
}