package be.vives.ti.stack;

import be.vives.ti.adt.Stack;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class LinkedListStack implements Stack<String> {
    private DoubleLinkedList<String> stack;

    public LinkedListStack() {
        this.stack = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(String s) {
        stack.addFirst(new Node<>(s));
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            return stack.removeFirst().getElement();
        }
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.getFirst().getElement();

    }
}