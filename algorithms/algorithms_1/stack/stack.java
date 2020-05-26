public class LinkedStackOfString{
{
    private Node first = null;

    public class Node 
    {
        String item;
        Node next;
    }

    public boolean isEmpty()
    {   return first == null; }

    public void push(String item)
    {
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
    }

    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }
}
