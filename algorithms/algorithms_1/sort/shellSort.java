public class shellSort{

    int[] a;
    int l;

    public shellSort(int[] arr){
        a = arr;
        l = a.length;
    }

    public int[] sort(omparable[] a){

        int h = 1;
        while(h<l/3) h = 3*h+1;

        while (h >= 1)
        {
            for (int i = h; i< l; i++){
                for (int j =i; j>=h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h)
            }
            h = h/3;
        }
    }

    public int[] mysort(Comparable[] a){
        int h = 0;
        while (h<l/3) h = 3*h+1;
        while(h>=1){
            for (int i =0; i<l-h;i++){
                for(j = i;j<l-h;J+=h){
                    if(a[j]>a[J+h])
                        exch(a, j+h, j)
                }
                h=h/3;
            }
        }
    }



        
    
    }
