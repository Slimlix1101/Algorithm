package StacksAndQueues;

public class ResizableArrayStackOfStrings {
    private String[] stack;
    private int N=0;

    public ResizableArrayStackOfStrings() { stack = new String[1]; }

    public boolean isEmpty() { return N==0; }

    public String pop() {

        if (isEmpty()) return "\b";
        String value = stack[--N];
        stack[N] = null; // remove the popped object
        if (N>0 && N == stack.length/4) resize(stack.length/2);
        return value;

    }

    public void push(String value) {

        if (N == stack.length) resize(stack.length*2);
        stack[N++] = value;
    }

    public void resize (int capacity)
    {
        String[] copy = new String[capacity];
        for (int i = 0; i<N; i++)
            copy[i] = stack[i];
        stack = copy;
    }
}
