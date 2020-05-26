public class quickThreeway{

    puclic void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo)  return;
        int lp = lo;
        int gt = hi;
        Comparable[] v = a[lo];
        int i = lo;
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<1)
                exchange(a, i++, lt++);
            if(cmp>1)
                exchnage(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
}
