public class merge{
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        assert isSorted(Comparable[] a, lo, mid);
        assert isSorted(Comparable[] a, mid+1, hi);

        for (int k = lo; k<=hi; k++)
            aux[k] = a[k];
    
        int i = lo;
        int j = mid+1;

        for (int k = lo; k<=hi; k++){
            if(i>mid) a[k] = aux[j++];
            if(j>hi)  a[k] = aux[i++];
            if(less(aux[j] aux[i]))  a[k] = aux[j++];
            else  a[k] = aux[i++]
        }

        assert isSorted(a, lo, hi);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
       if(hi <= lo) return;
       int mid = lo + (hi-lo)/2;
       sort(Comparable[] a, Comparable[] aux, int lo, mid);
       sort(Comparable[] a, Comparable[] aux, mid+1, hi);
       merge(Comparable[] a, Comparable[] aux, lo mid+1, hi);
    }
    
    //creating aux array in sort can lead to bugs
    public static sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

}
