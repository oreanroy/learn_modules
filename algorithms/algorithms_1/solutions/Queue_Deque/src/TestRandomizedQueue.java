import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestRandomizedQueue {
    private RandomizedQueue ran;
    public TestRandomizedQueue(){
        ran = new RandomizedQueue();
    }

    @Test
    public void testAddRemFirst(){
        ran.enqueue("tom");
        ran.enqueue("cat");
        ran.enqueue("mouse");
        for(Object s: ran){
            System.out.println(s);
        }
        System.out.println(ran.sample());
        assertNotEquals(ran.sample(), ran.sample());
        assertEquals(ran.size(), 3);
        assertNotEquals(ran.dequeue(), ran.dequeue());
        assertEquals(ran.size(), 1);
    }
}
