package StacksAndQueues;

public class LinkedStackOfStrings {

    private Node first = null;
    private class Node { // inner class
        String value;
        Node next;
    }
    public String GetFirstValue() { return first.value; }

    public boolean isEmpty() { return first == null; }
    public String pop() {
        if (isEmpty()) return "\b"; // return a backspace
        String value = first.value;
        first = first.next;
        return value;
    }
    public void push(String value) {
        Node oldfirst = first;
        first = new Node(); // re-initialize Node first
        first.value = value;
        first.next = oldfirst;
    }
}
