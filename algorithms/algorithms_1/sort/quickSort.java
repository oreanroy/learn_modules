public class Ouick
{
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true){
            while(less(a[++i], a[lo]))
                if(i>=hi)
                    break;
            while(les(a[lo],a[--j]))
                if(j<=lo)
                    break;
            if(j<i)
                break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
            return j;
    }

    public static void sort(Comparable[] a)
    {
        public static void sort(Comparable[] a)
        {
            StdRandom.shuffle(a);
            sort(a, 0, a.length-1);
        }

        private staic void sort(Comparable[] a, int lo, int hi){
            if(hi<=lo)
                return;
            int j= partition(a, lo, hi);
            sort(a, lo, j-1);
            sort(a, j+1, hi);
            }
    }
}
