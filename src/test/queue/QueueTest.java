package test.queue;

import main.queue.Queue;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class QueueTest {

    Queue myQueue = new Queue( 2 );

    @Test
    public void  fifo(){
        myQueue.push(0);
        myQueue.push(0);
        myQueue.push(0);

        int zero = myQueue.pop();
        int one = myQueue.pop();
        int two = myQueue.pop();

        assertThat(zero, equalTo(0));
        assertThat(one, equalTo(1));
        assertThat(two, equalTo(2));
    }

}
