package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class LinkedListPriorityQueue implements PriorityQueue<Integer> {

    private DoubleLinkedList<Integer> priorityQueue;

    public LinkedListPriorityQueue() {
        this.priorityQueue = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return priorityQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public void insert(Integer integer) {
        Node<Integer> newNode = new Node<>(integer);
        Node<Integer> first = priorityQueue.getFirst();

        if (first == null || first.getElement() >= integer) {
            priorityQueue.addFirst(newNode);
        } else {
            Node<Integer> next = first.getNext();
            Node<Integer> previous = first;
            while (next != null && next.getElement() < integer) {
                previous = next;
                next = next.getNext();
            }
            priorityQueue.addAfter(previous, newNode);
        }
    }

    @Override
    public Integer removeMin() {
        Node<Integer> first = priorityQueue.removeFirst();
        if (first != null) {
            return first.getElement();
        }
        return null;
    }

    @Override
    public Integer min() {
        Node<Integer> first = priorityQueue.getFirst();
        if (first != null) {
            return first.getElement();
        }
        return null;
    }
}
