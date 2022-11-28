package main.queue;

public class Queue {
    private static final int INTIAL_SIZE = 2;
    private int[] queue;
    private int popPointer;
    private int pushPointer;

    public Queue() {
        this.queue = new int[INTIAL_SIZE];
        popPointer = 0;
        pushPointer = 0;
    }
    public Queue(final int initialSize) {
        this.queue = new int[initialSize];
        popPointer = 0;
        pushPointer = 0;
    }

    public void push(final int x) {

        if(pushPointer == this.queue.length) {
            this.expand();
        }

        this.queue[pushPointer] = x;
        pushPointer++;
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
        /*
        r = 0
        w = 5
        val = [3,4,5,6,7]
        ind = [0,1,2,3,4]

        r < w
         */
        int val = queue[popPointer];
        popPointer++;
        return val;
    }
}
