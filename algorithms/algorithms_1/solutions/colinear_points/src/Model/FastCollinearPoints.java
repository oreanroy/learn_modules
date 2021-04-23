package Model;//package Model;

import java.util.Comparator;

public class FastCollinearPoints {

    private int count;
    private int l;
    private node current=null;
    private node first=null;
    private  int incre=1;

    private class node {
        public LineSegment present;
        public FastCollinearPoints.node next;
        void node(){
            this.present = null;
            this.next = null;
        }
    }

    public FastCollinearPoints(Point[] points){
        if(points==null)
            throw new IllegalArgumentException();
        l = points.length;
        if(l<=0)
            throw new IllegalArgumentException();

        for(int i=0; i<l; i++)
            if(points[i]==null)
                throw new IllegalArgumentException();

        sortByCoordinate(points);
        checkDublicate(points);

        for(int i = 0; i<l-3; i+=incre){
            if(i>l-3)
                break;
            Point ref = points[i];
            double[] slopes = slopeToPoint(ref, points, i);
            sortSlopes(slopes, points, i);
            findCollinear(points, slopes, ref, i);
            sortByCoordinate(points);
        }
    }
    // finds all line segments containing 4 or more points

    private void checkDublicate(Point[] points){
        for(int i=0; i<l-1; i++){
            if(points[i].compareTo(points[i+1])==0)
                throw new IllegalArgumentException();
        }
    }

    private double[] slopeToPoint(Point p, Point[] points, int index){
        double[] arr = new double[l];
        for(int i=index+1; i<l;i++)
            arr[i] = p.slopeTo(points[i]);
        return arr;
    }

    private void sortByCoordinate(Point[] points){
        for(int i =0; i<l; i++){
            for(int j = i; j>0 && points[j].compareTo(points[j-1])<0; j--){
                exchange(points, j, j-1);
            }
        }
    }

    private void sortSlopes(double[] slopes, Point[] points, int index){
        for(int i =index+1; i<l; i++){
            for(int j = i; j > 0 && slopes[j]<slopes[j-1]; j--){
                exchangeDouble(slopes, j, j-1);
                exchange(points, j, j-1);
            }
        }
    }

    private void sortByPoint(Point p, Point[] points, int startIndex){
        Comparator comparator = p.slopeOrder();
        for(int i=startIndex; i<l; i++){
            for(int j = i-1; j>startIndex && less(comparator, points[i], points[j]); j--){

            }
        }
    }

    private void findCollinear(Point[] points, double[] slopes, Point p, int index){

        /*
        for(int i=index+1;i<=l-3;i++){
         if(slopes[i]==slopes[i+1]&&slopes[i+1]==slopes[i+2]){
            count++;
             Point[] arr = findExtremePoints(points[i], points[i+1], points[i+2], p);
             LineSegment line = new LineSegment(arr[0], arr[1]);
             if (count == 1) {
                  node Node = new node();
                 Node.present = line;
                 current = Node;
                 first = Node;
             } else {
                 node Node = new node();
                 Node.present = line;
                 current.next = Node;
                 current = Node;
             }
         }
        } */
        int colinear = 0;
        for(int i = index+1;i<l-1;i++){
            if (slopes[i] == slopes[i+1]) {
                int t = i;
             while(t<l-1 && slopes[t]==slopes[t+1])
             {
                 colinear++;
                 t++;
             }
            }
            if(colinear>=2){
                count++;
                incre = count-3;
                Point[] arr = findExtremePoints(split(points, i,i+colinear));
                LineSegment line = new LineSegment(arr[0], arr[1]);
                if (count == 1) {
                    node Node = new node();
                    Node.present = line;
                    current = Node;
                    first = Node;
                } else {
                    node Node = new node();
                    Node.present = line;
                    current.next = Node;
                    current = Node;
                }
            }else {
                incre =1;
            }
            colinear=0;
        }
    }

    private Point[] split(Point[] points, int i, int j){
        int len = j-i;
        Point[] splittedArray = new Point[len];
        for(int k=0;k<len;k++){
            splittedArray[k]=points[k+len];
        }
        return splittedArray;
    }

    private void sortByCoordinateSmaller(Point[] points){
        int len = points.length;
        for(int i =0; i<len; i++){
            for(int j = i; j>0 && points[j].compareTo(points[j-1])<0; j--){
                exchange(points, j, j-1);
            }
        }
    }

    public Point[] findExtremePoints(Point[] tmepPoints){
        int len = tmepPoints.length;
        Point[] arr = new Point[2];
        sortByCoordinateSmaller(tmepPoints);
        arr[0]=tmepPoints[0];
        arr[1]=tmepPoints[len-1


                ];
        return arr;
    }

    private boolean less(Comparator c, Point a, Point b){
        return c.compare(a, b)<0;
    }

    private void exchange(Object[] points, int i, int j){
        Object temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }


    private void exchangeDouble(double[] points, int i, int j){
        double temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }


    public int numberOfSegments() {
        return count;
    }
    // the number of line segments



    public LineSegment[] segments(){
        LineSegment[] arr = new LineSegment[count];
        int t = 0;
        node current = first;
        while (current!=null){
            arr[t] = current.present;
            current = current.next;
            t++;
        }
        return arr;
    }
    // the line segments
    public static void main(String[] args) {


    }
}