package main.queue;

public class Queue {
    private static final int INITIAL_SIZE = 2;
    private int[] queue;
    private int popPointer;
    private int pushPointer;
    private int elementCount;

    public Queue() {
        this.queue = new int[INITIAL_SIZE];
        popPointer = 0;
        pushPointer = 0;
        elementCount = 0;
    }
    public Queue(final int initialSize) {
        this.queue = new int[initialSize];
        popPointer = 0;
        pushPointer = 0;
        elementCount = 0;
    }

    public void push(final int x) {

        if(queueIsFull()) {
            this.expand();
        }

        // Queue is not full, but we need to loop the pointer around to add to the beginning of the queue.
        if (pushPointer >= this.queue.length) {
            pushPointer = 0;
        }

        this.queue[pushPointer] = x;
        pushPointer++;
        elementCount++;
    }

    private boolean queueIsFull() {
        return elementCount == this.queue.length;
    }

    private void expand() {
        int doubleCurrentSize = this.queue.length * 2;
        int[] biggerQueue = new int[doubleCurrentSize];

        for (int i = 0; i < this.queue.length; i++) {
            biggerQueue[i] = queue[i];
        }

        this.queue = biggerQueue;
    }

    public int size() {
        return this.queue.length;
    }

    public int pop() {
        int val = queue[popPointer];
        popPointer++;
        elementCount--;

        if ( queueLessThanHalfFull() ) {
            this.shrink();
        }

        if (popPointer == this.queue.length) {
            // Loop back around to the front of the queue
            popPointer = 0;
        }

        return val;
    }

    private void shrink() {

        // Take the opportunity to reset the pointers on the new queue

        int[] smallerQueue = new int[midPointIndex()];

        for (int i = 0; i < elementCount; i++) {
            int readOffset = popPointer + i;
            if (readOffset >= queue.length) {
                readOffset = readOffset - queue.length;
            }
            smallerQueue[i] = queue[readOffset];
        }
        this.popPointer = 0;
        this.pushPointer = pushPointer - midPointIndex();

        this.queue = smallerQueue;
    }

    private boolean queueLessThanHalfFull() {
        return elementCount < midPointIndex();
    }

    private int midPointIndex() {
        return this.queue.length / 2;
    }

}
