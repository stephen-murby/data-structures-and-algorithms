package test.queue;

import main.queue.Queue;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class QueueTest {
    private Queue myQueue;
    final int FIRST = 0;
    final int SECOND = 1;
    final int THIRD = 2;
    final int FOURTH = 3;
    final int FIFTH = 4;

    @Before
    public void setup() {
        myQueue = new Queue( 2 );
    }

    @Test
    public void  fifo(){

        myQueue.push(FIRST);
        myQueue.push(SECOND);
        myQueue.push(THIRD);

        assertThat(myQueue.pop(), equalTo(FIRST));
        assertThat(myQueue.pop(), equalTo(SECOND));
        assertThat(myQueue.pop(), equalTo(THIRD));
    }

    @Test
    public void queueExpandsWhenFull(){
        assertThat (myQueue.size(), equalTo(2));

        myQueue.push(FIRST);
        myQueue.push(SECOND);
        myQueue.push(THIRD);
        assertThat (myQueue.size(), equalTo(4));
    }

    @Test
    public void queueShrinksWhenLessThanHalfFull(){
        assertThat (myQueue.size(), equalTo(2));

        myQueue.push(FIRST);
        myQueue.push(SECOND);
        myQueue.push(THIRD);
        assertThat (myQueue.size(), equalTo(4));

        myQueue.push(FOURTH);
        myQueue.push(FIFTH);
        assertThat (myQueue.size(), equalTo(8));

        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        assertThat (myQueue.size(), equalTo(4));

    }

}
