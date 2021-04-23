import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeque {
    private Deque  deq;
    public TestDeque(){
        deq = new  Deque();
    }

    @Test
    public void testAddRemFirst(){
        deq.addFirst("tom");
        deq.addFirst("cat");
        deq.addLast("mouse");
        for(Object s: deq){
            System.out.println(s);
        }

        assertEquals(deq.size(), 3);
        assertEquals(deq.removeFirst(), "cat");
        assertFalse(deq.isEmpty());
        assertEquals(deq.size(), 2);
        assertEquals(deq.removeLast(), "mouse");
        assertFalse(deq.isEmpty());
        assertEquals(deq.size(), 1);
        assertEquals(deq.removeFirst(), "tom");
        assertTrue(deq.isEmpty());
        assertEquals(deq.size(), 0);
    }
}
