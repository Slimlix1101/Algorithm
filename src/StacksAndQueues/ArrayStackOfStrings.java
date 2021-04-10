package StacksAndQueues;

public class ArrayStackOfStrings {
    private String[] stack;
    private int N;
    // N represents the next index of the last object in stack
    // when N=0, the stack is empty
    // when N>0, the stack's size exceeds the array's capacity, resulting in overflow

    public ArrayStackOfStrings(int capacity) { stack = new String[capacity]; }

    public boolean isEmpty() { return N==0; }

    public String pop() {
        if (isEmpty()) return "\b";
        return stack[--N];
    }

    public void push(String value) { stack[N++] = value; }
}
