package Test;

import Model.FastCollinearPoints3;
import Model.LineSegment;
import Model.Point;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FastCollinearPointsTest3 {

    FastCollinearPoints3 fastObject;
    Point[] pointsArray;

     @Test
    public void testCoordinateSort(){
        pointsArray = new Point[4];
        Point p1 = new Point(4,3);
        pointsArray[0] = p1;
        Point p2 = new Point(3, 3);
        pointsArray[1] = p2;
        Point p3 = new Point(3, 6);
        pointsArray[2] = p3;
        Point p4 = new Point(3, 5);
        pointsArray[3] = p4;
        fastObject = new FastCollinearPoints3(pointsArray);
        //assertEquals(fastObject.numberOfSegments(), 2);
    }



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
        fastObject = new FastCollinearPoints3(pointsArray);
        assertEquals(fastObject.numberOfSegments(), 1);
    }

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
        pointsArray[4] = p4;
        Point p6 = new Point(3, 5);
        pointsArray[5] = p6;
        Point p7 = new Point(3, 6);
        pointsArray[6] = p7;
        fastObject = new FastCollinearPoints3(pointsArray);
        assertEquals(fastObject.numberOfSegments(), 2);
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
        fastObject = new FastCollinearPoints3(pointsArray);
        assertEquals(fastObject.numberOfSegments(), 2);
    }

    @Test
    public void testTwoParallelDisorientedLine(){
        pointsArray = new Point[8];
        Point p1 = new Point(3,3);
        pointsArray[0] = p1;
        Point p2 = new Point(3, 4);
        pointsArray[1] = p2;
        Point p3 = new Point(3, 5);
        pointsArray[2] = p3;
        Point p4 = new Point(3, 6);
        Point p5 = new Point(2, 2);
        Point p6 = new Point(2, 3);
        pointsArray[5] = p5;
        pointsArray[4] = p4;
        pointsArray[3] = p6;
        Point p7 = new Point(2, 4);
        pointsArray[6] = p7;
        Point p8 = new Point(2, 5);
        pointsArray[7] = p8;
        fastObject = new FastCollinearPoints3(pointsArray);
        assertEquals(fastObject.numberOfSegments(), 2);
    }


    @Test
    public void testLineSegment(){
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
        pointsArray[4] = p4;
        Point p6 = new Point(3, 5);
        pointsArray[5] = p6;
        Point p7 = new Point(3, 6);
        pointsArray[6] = p7;
        fastObject = new FastCollinearPoints3(pointsArray);
        System.out.println(fastObject.numberOfSegments());
        LineSegment[] lines = fastObject.segments();
        //System.out.println(lines.length);
        for (LineSegment line: lines){
            System.out.println(line);
        }
        //assertEquals(fastObject.numberOfSegments(), 2);
    }

    /*
    @Test
    public void testExtremePoints(){
        pointsArray = new Point[4];
        Point p1 = new Point(4,4);
        pointsArray[0] = p1;
        Point p2 = new Point(3, 3);
        pointsArray[1] = p2;
        Point p3 = new Point(6, 6);
        pointsArray[2] = p3;
        Point p4 = new Point(5, 5);
        pointsArray[3] = p4;
        fastObject = new FastCollinearPoints3(pointsArray);
        Point[] arr = fastObject.findExtremePoints(pointsArray, p1);
        for (Point point: arr){
            System.out.println(point);
        }
        //assertEquals(fastObject.numberOfSegments(), 2);
    }

     */

    @Test
    public void testCompare(){
         Point p1 = new Point(3,3);
         Point p2 = new Point(6, 6);
         LineSegment lin1 = new LineSegment(p1, p2);
         LineSegment lin2 = new LineSegment(p1, p2);
         System.out.println(lin1.toString());
         System.out.println(lin2.toString());
         System.out.println(lin1.toString()==lin2.toString());
         assertEquals(lin1.toString(), lin2.toString());
    }


    //(1000, 1000) -> (2000, 2000) -> (3000, 3000) -> (4000, 4000) ->
    // (5000, 5000) -> (6000, 6000) -> (7000, 7000) -> (8000, 8000) -> (9000, 9000)

    @Test
    public void testLongStraightLIne(){
        pointsArray = new Point[9];
        Point p1 = new Point(1000,1000);
        pointsArray[0] = p1;
        Point p2 = new Point(2000, 2000);
        pointsArray[1] = p2;
        Point p3 = new Point(3000, 3000);
        pointsArray[2] = p3;
        Point p4 = new Point(4000, 4000);
        pointsArray[3] = p4;
        Point p5 = new Point(5000, 5000);
        pointsArray[4] = p5;
        Point p6 = new Point(6000, 6000);
        pointsArray[5] = p6;
        Point p7 = new Point(7000, 7000);
        pointsArray[6] = p7;
        Point p8 = new Point(8000, 8000);
        pointsArray[7] = p8;
        Point p9 = new Point(9000, 9000);
        pointsArray[8] = p9;
        fastObject = new FastCollinearPoints3(pointsArray);
        for(LineSegment line: fastObject.segments()){
            System.out.println(line.toString());
        }
        assertEquals(fastObject.numberOfSegments(), 1);

    }
}
