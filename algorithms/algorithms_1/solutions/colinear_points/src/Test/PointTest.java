package Test;

import Model.Point;
import org.junit.Test;

public class PointTest {
    @Test
    public void testSlope(){
        Point p1 = new Point(5,5);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(3, 5);
        Point p4 = new Point(3,6);
        double s1 = p1.slopeTo(p2);
        double s2 = p1.slopeTo(p3);
        double s3 = p1.slopeTo(p4);
        System.out.println(p1.slopeTo(p2));
        System.out.println(p1.slopeTo(p3));
        System.out.println(p1.slopeTo(p4));
    }

}
