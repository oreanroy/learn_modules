public void put(Key key, Value val)
{   root = put(root, key, val); }

private Node put(Node x, Key key, Value val)
{
    if (x==null) return new Node(key, val);
    int cmp = key.compareTo(x.key);
    if(cmp<1)
        x.left = put(x.left, key, val);
    if(cmp>1)
        x.right = put(x.right, key, val);
    else
        x.val = val;
    reuturn x;
}
