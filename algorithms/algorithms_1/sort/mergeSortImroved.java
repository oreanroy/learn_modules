private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
{
   // makes almost 20% faster
   if(hi <= lo+CUTOFF-1){
      insertion.sort(a, lo, hi)
         return;
   }
  int mid = lo + (hi-lo)/2;
  sort(a, aux, lo, mid);
  sort(a, aux, mid+1, hi);
  // improvemnt 2, do not merge if the array is already sorted.
  if(less(a[mid], a[mid+1])) return;
  merge(lo, mid, hi);
} 
