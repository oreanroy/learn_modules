/* we keep track of weights of each root and a add the samller one 
   to the root of larger one

*/


public class WeightedQuickUnionUF {
    
    private int[] id;
    private int[] size;

    public WeightedQuickUnionUF(N){  
        id = new int[N];
        size = new int[N];
    for (int i=0; i<N; i++){
        id[i] = i;
        size[i] = 1;
    }

    private int root(int p){
        while(int[i]!=i)
            i = int[i];
        return i
    }

    public boolean connected(int p, int q){
        return root(p) == root(q)
    }


    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        if(!connected(p, q)){
            if(size[rootP]>size[rootQ]){
                id[rootQ] = rootP;
                size[rootP]+=size[rootQ];
            }
            else{
                id[rootP] = rootQ;
                size[rootQ]+=size[rootP]; 
            }

        }
}
    
/* analyis 

    The hight of a given tree only increases when tree of same height or greater is
    added to the tree. And after each such adition the element in the given tree
    becomes twice or more, so for a given length tree the longest height that you can 
    acheive is log(N). Hence the worst case to find a root would be log(n)... log(n-1) 
    to be specific

    algorithm       initialize      union       connected
    
    quick-find        N               N            1
    quick-union       N               N+           N
    weighted QU       N              log(N)+      log(N)

*/   

