package Model;

public class BruteCollinearPoints {

    private int count = 0;
    private node first;
    private node current;
    private class node {
        public LineSegment present;
        public node next;
        void node(){
            this.present = null;
            this.next = null;
        }
    }

    public BruteCollinearPoints(Point[] points){
        if(points==null)
            throw new IllegalArgumentException();
        int l = points.length;
        if(l<=0)
            throw new IllegalArgumentException();


        for(int i=0; i<l; i++)
            if(points[i]==null)
                throw new IllegalArgumentException();
        checkDublicate(points);

        for (int i = 0; i<l; i++){
            for(int j = i+1; j<l; j++){
                for(int k = j+1; k<l; k++){
                    for(int m = k+1; m<l; m++) {
                        if (points[i].compareTo(points[j]) != 0 && points[i].compareTo(points[k]) != 0 && points[i].compareTo(points[m]) != 0
                                && points[j].compareTo(points[k]) != 0 && points[j].compareTo(points[m]) != 0 && points[k].compareTo(points[m]) != 0)
                        {
                            if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) && points[i].slopeTo(points[k]) == points[i].slopeTo(points[m])) {
                                count++;
                                Point[] arr = findExtremePoints(points[i], points[j], points[k], points[m]);
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
                        }
                    }
                }
            }

        }
    }


    private void checkDublicate(Point[] points){
        int l = points.length;
        for(int i =0; i<l; i++){
            for(int k = 0; k<l; k++)
                if(points[i].compareTo(points[k])==0 && i != k)
                    throw new IllegalArgumentException();
        }
    }

    // finds all line segments containing 4 points
    private void exchange(Object[] points, int i, int j){
        Object temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }


    private void sortByCoordinateSmaller(Point[] points){
        for(int i =0; i<4; i++){
            for(int j = i; j>0 && points[j].compareTo(points[j-1])<0; j--){
                exchange(points, j, j-1);
            }
        }
    }

    public Point[] findExtremePoints(Point p1, Point p2, Point p3, Point p4){
        Point[] temp = new Point[4];
        temp[0]=p1;
        temp[1]=p2;
        temp[2]=p3;
        temp[3]=p4;
        Point[] arr = new Point[2];
        sortByCoordinateSmaller(temp);
        arr[0]=temp[0];
        arr[1]=temp[3];
        return arr;
    }

    public           int numberOfSegments(){
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
    // the line segments4
    public static void main(String[] args) {

    }
}