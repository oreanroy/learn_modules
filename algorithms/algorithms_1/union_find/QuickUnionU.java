/* 
 
    this provides a faster union by chaging the data satructure in a 
    a tree/forest representaion so for union of two elements you just change
    the roor of either one to another one
    find check if the roots are same 

*/


public class QuickUnionUF {

    private int[] id;

    // set id of each element to self in starting
    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i=0; i<n; i++){
            id[i] = i;
        }

    // chase the parent pointer untill the id[i] is same as i 
    // acces eqaul to depth of tree
    private int root(int i){
        while(id[i]!=i){
            i = id[i];
        }
        return i;
    }
    
    // check if p and q have the same root
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

 
    // change the root of p to q   
    public void union(int p, int q){
        if(!connected(p, q){
            int rootP = root(p);
            int rootQ = root(q);
            id[rootP] = rootQ;
        }
    }
}

/* analysis 

    FIND will take time equal to calcualting the root of each element 
    can be max (N-1) in worst case

    UNION will take time time equal to calulating the root and some constant time
    can be max (N-1)+ in worst case 

    algorithm         initialize          union       find

    quick-find         N                    N           1
    quick-union        N                    N+          N


    quick find
        trees are flat but union is too expesive (keeping the trees flat is expensive)
    quick Union
        trees can become long, find expensive(could N in worst both union and find)

*/
