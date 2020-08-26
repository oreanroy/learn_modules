private class Node
{
    private Key key;
    private Value val;
    private Node left;
    private Node right;
    private int count;
}

public int size()
{   return size(root); }

private int size(Node x)
{
    if(x==null) return 0;
    return x.count;
}

private Node put(Node x, Key key, Val val)
{
    if(x==null) return new Node(key, val, 1);
    int cmp = key.compareTo(x.key);
    if(cmp<1)
        x.left = put(x.left, key, val);
    if(cmp>1)
        x.right = put(x.right, key, val);
    else
        x.val = val;
    x.count = 1 + size(x.left) + size(x.right);
    return x;
}
