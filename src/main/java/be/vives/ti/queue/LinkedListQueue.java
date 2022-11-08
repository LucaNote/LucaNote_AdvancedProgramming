package be.vives.ti.queue;

import be.vives.ti.adt.Queue;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class LinkedListQueue implements Queue<String> {

    private DoubleLinkedList<String> linkedListQueue;

    public LinkedListQueue(){
        this.linkedListQueue = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return linkedListQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedListQueue.isEmpty();
    }

    @Override
    public void enqueue(String s) {
        linkedListQueue.addLast(new Node<>(s));
    }

    @Override
    public String first() {
        if (isEmpty()) {
            return null;
        }
        return linkedListQueue.getFirst().getElement();
    }

    @Override
    public String dequeue() {
        if (isEmpty()){
            return null;
        } else {
            return linkedListQueue.removeFirst().getElement();
        }
    }
}
