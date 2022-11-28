package main.stack;

public class Stack {
    private int INITIAL_SIZE = 2;
    private int[] stack;
    private int pointer;

    public Stack() {
        this.stack = new int[INITIAL_SIZE];
        this.pointer = 0;
    }

    public void push(int x) {
        this.stack[pointer] = x;

        if (pointer == lastArrayIndex()) {
            this.expand();
        }

        pointer++;
    }

    public int pop() {
        pointer--;
        int val = stack[pointer];

        if (pointer == indexHalfWayThroughArray() - 1) {
            this.shrink();
        }
        return val;
    }

    private void shrink() {
        int halfTheSize = this.stack.length / 2;

        int[] smallerStack = new int[halfTheSize];
        for (int i = 0; i < indexHalfWayThroughArray(); i++) {
            smallerStack[i] = stack[i];
        }

        this.stack = smallerStack;
    }

    private int indexHalfWayThroughArray() {
        return stack.length / 2;
    }

    public int size() {
        return stack.length;
    }

    private void expand() {
        final int biggerStackSize = stack.length * 2;
        int[] biggerStack = new int[biggerStackSize];

        for(int i = 0; i < stack.length; i++) {
            biggerStack[i] = stack[i];
        }

        this.stack = biggerStack;
    }

    private int lastArrayIndex() {
        return stack.length - 1;
    }
}
