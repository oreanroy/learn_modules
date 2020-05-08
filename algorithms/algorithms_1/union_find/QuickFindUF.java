public class QuickFindUF
{
    private int[] id;
    
    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i=0; i<N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q)
    {   return id[p] == id[q]; }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for (int i=0; i<n; i++){
            if(id[i] == pid)
                id[i] = qid;
    }
}


// anlysis 
// connected constant time
// union takes n time
// n union operation will take n^2 time

// algorithm  initialize   union    find

// quick-find   N           N        1 
    
