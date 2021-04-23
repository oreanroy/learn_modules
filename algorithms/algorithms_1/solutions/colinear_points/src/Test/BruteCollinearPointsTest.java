package Test;

import Model.BruteCollinearPoints;
import Model.LineSegment;
import Model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BruteCollinearPointsTest {

    BruteCollinearPoints bruteObject;
    Point[] pointsArray;


    @Test
    public void testStraightLIne(){
        pointsArray = new Point[4];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(4, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(5, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(6, 6);
        pointsArray[3] = p4;
        bruteObject = new BruteCollinearPoints(pointsArray);
        assertEquals(bruteObject.numberOfSegments(), 1);
    }


    // they are not supplying 5 or more coolinear point, so this test can be left
   /* @Test
    public void testTwoStraightLIne(){
        pointsArray = new Point[5];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(4, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(5, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(6, 6);
        pointsArray[3] = p4;
        Point p5 = new Point(7, 7);
        pointsArray[4] = p5;
        bruteObject = new BruteCollinearPoints(pointsArray);
        assertEquals(bruteObject.numberOfSegments(), 2);
    } */
    @Test
    public void testTwoConvexLIne(){
        pointsArray = new Point[7];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(4, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(5, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(6, 6);
        //pointsArray[3] = p4;
        Point p5 = new Point(3, 4);
        pointsArray[3] = p5;

        Point p6 = new Point(3, 5);
        pointsArray[4] = p6;
        pointsArray[5] = p4;
        Point p7 = new Point(3, 6);
        pointsArray[6] = p7;
        bruteObject = new BruteCollinearPoints(pointsArray);
        assertEquals(bruteObject.numberOfSegments(), 2);
    }

    @Test
    public void testTwoParallelLIne(){
        pointsArray = new Point[8];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(3, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(3, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(3, 6);
        pointsArray[3] = p4;
        Point p5 = new Point(2, 2);
        pointsArray[4] = p5;
        Point p6 = new Point(2, 3);
        pointsArray[5] = p6;
        Point p7 = new Point(2, 4);
        pointsArray[6] = p7;
        Point p8 = new Point(2, 5);
        pointsArray[7] = p8;
        bruteObject = new BruteCollinearPoints(pointsArray);
        assertEquals(bruteObject.numberOfSegments(), 2);
    }

    @Test
    public void testTwoPerpendicularLine(){
        pointsArray = new Point[7];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(4, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(5, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(6, 6);
        pointsArray[3] = p4;
        Point p5 = new Point(5, 3);
        pointsArray[4] = p5;
        Point p6 = new Point(3, 5);
        pointsArray[5] = p6;
        Point p7 = new Point(2, 6);
        pointsArray[6] = p7;
        bruteObject = new BruteCollinearPoints(pointsArray);
        assertEquals(bruteObject.numberOfSegments(), 2);
    }


    @Test
    public void testLineSegment(){
        pointsArray = new Point[4];
        Point p1 = new Point(4,4);
        pointsArray[0] = p1;
        Point p2 = new Point(5, 5);
        pointsArray[1] = p2;
        Point p3 = new Point(3, 3);
        pointsArray[2] = p3;
        Point p4 = new Point(6, 6);
        pointsArray[3] = p4;
        bruteObject = new BruteCollinearPoints(pointsArray);
        System.out.println(bruteObject.numberOfSegments());
        LineSegment[] lines = bruteObject.segments();
        System.out.println(lines.length);
        for (LineSegment line: lines){
            System.out.println(line);
        }
        //assertEquals(fastObject.numberOfSegments(), 2);
    }

}
