package test.stack;

import main.stack.Stack;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    @Test
    public void shouldResizeWhenInitialSizeExceeded(){

        Stack myStack = new Stack();
        assertThat(myStack.size(), equalTo(2));

        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        assertThat(myStack.size(), equalTo(4));

        final int two = myStack.pop();
        final int one = myStack.pop();

        assertThat(myStack.size(), equalTo(2));
    }

    @Test
    public void lifo(){
        Stack myStack = new Stack();

        myStack.push(0);
        myStack.push(1);
        myStack.push(2);

        final int two = myStack.pop();
        final int one = myStack.pop();
        final int zero = myStack.pop();

        assertThat(two, equalTo(2));
        assertThat(one, equalTo(1));
        assertThat(zero, equalTo(0));
    }

    @Test
    public void sort(){
        // TODO ( Implement stack sorting algorithm )
    }
}
