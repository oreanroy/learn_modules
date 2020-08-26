public Key floor(Key key)
{
    Node x = floor(root, key);
    if (x == null) return null;
    return x.key;
}

public key floor(Node x, Key key)
{
    if(x == null) return null;
    int cmp = key.comapreTo(x.key);
    if(cmp ==0 ) return x;
    if(cmp < 1) return floor(x.left, Key key);
    Node t = floor(x.right, Key key);
    if(t==null) return x;
    return t;
}

