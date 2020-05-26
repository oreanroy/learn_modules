public class MergeBu
{
    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        for(int i=0;i<a.length;i++)
            aux[i] = a[i];
        int i = lo;
        int j = mid;
        for (int k =0; k<hi;k++){
            if(i>=mid) a[k] = aux[j++];
            if(j>=hi)  a[k] = aux[i++];
            if(less(aux[i], aux[j])) a[k] = aux[i++];
            else
                a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz<N; sz+=sz)
            for(int lo = 0; lo < N-sz; lo+=sz+sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz-1, N-1));
    }
} 
