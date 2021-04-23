package Model;


public class FastCollinearPoints3 {
    private int count=0;
    private int l;
    private node current=null;
    private node first=null;

    private class node {
        public LineSegment present;
        public FastCollinearPoints3.node next;
        void node(){
            this.present = null;
            this.next = null;
        }
    }

    public FastCollinearPoints3(Point[] points){

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
        for(int i=0; i<l-1; i++){
            Point ref = points[i];
            double[] slopes = slopeToPoint(points[i], points);
            sortSlopes(slopes, points);
            findUniqueCollinear(slopes, points, ref);
            sortByCoordinate(points);
        }

    }     // finds all line segments containing 4 or more points

    private void checkDublicate(Point[] points){
        for(int i=0; i<l-1; i++){
            if(points[i].compareTo(points[i+1])==0)
                throw new IllegalArgumentException();
        }
    }

    private double[] slopeToPoint(Point p, Point[] points){
        double[] arr = new double[l];
        for(int i=0; i<l;i++)
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



    private void sortSlopes(double[] slopes, Point[] points){
        for(int i =0; i<l; i++){
            for(int j = i; j > 0 && slopes[j]<slopes[j-1]; j--){
                exchangeDouble(slopes, j, j-1);
                exchange(points, j, j-1);
            }
        }
    }

    private void findUniqueCollinear(double[] slopes, Point[] points, Point p){
        int colinear = 0;
        for(int i =0; i<l-1; i++){
            int start = i;
            if(slopes[i] == slopes[i+1]){
                int t = i;
                while(t<l-1 && slopes[t]==slopes[t+1]){
                    colinear++;
                    t++;
                }
                if(colinear>=2){
                    Point[] arr = findExtremePoints(split(points, start,i+colinear), p);
                    LineSegment line = new LineSegment(arr[0], arr[1]);
                    if(notPresent(line)){
                        count++;
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
                    i+=colinear;
                }
                colinear=0;
            }
        }
    }


    private boolean notPresent(LineSegment line){
        node current = first;
        while (current!=null){
            //System.out.println(current.slope+" "+slope);
            if(current.present.toString().equals(line.toString()))
                return false;
            current = current.next;
        }
        return true;
    }


    private Point[] findExtremePoints(Point[] tmepPoints, Point p){
        Point[]  newTemp = new Point[tmepPoints.length+1];
        newTemp[0]=p;
        int len = newTemp.length;
        for(int i=1; i<len; i++)
            newTemp[i]=tmepPoints[i-1];
        Point[] arr = new Point[2];
        sortByCoordinateSmaller(newTemp);
        arr[0]=newTemp[0];
        arr[1]=newTemp[len-1];
        return arr;
    }

    private Point[] split(Point[] points, int i, int j){
        int len = j-i+1;
        Point[] splittedArray = new Point[len];
        for(int k=0;k<len;k++){
            splittedArray[k]=points[i++];
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

    public           int numberOfSegments(){
        return count;
    }        // the number of line segments


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
    }             // the line segments

    public static void main(String[] args) {

    }
}