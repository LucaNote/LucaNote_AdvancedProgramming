package be.vives.ti.list;

import be.vives.ti.adt.List;
import be.vives.ti.linkedlist.DoubleLinkedList;
import be.vives.ti.linkedlist.Node;

public class MyLinkedList implements List<String> {

    private DoubleLinkedList<String> linkedListQueue;

    public MyLinkedList() {
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
    public String get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return getNodeAtIndex(i).getElement();
    }

    @Override
    public String set(int i, String s) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        String oldValue = getNodeAtIndex(i).getElement();
        getNodeAtIndex(i).setElement(s);
        return oldValue;
    }

    @Override
    public void add(int i, String s) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (isEmpty()){
            linkedListQueue.addFirst(new Node<>(s));
        } else {
            linkedListQueue.addAfter(getNodeAtIndex(i).getPrevious(),new Node<>(s));
        }
    }

    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return linkedListQueue.remove(getNodeAtIndex(i)).getElement();
    }

    @Override
    public void add(String s) throws IndexOutOfBoundsException {
        add(size(),s);
    }

    private Node<String> getNodeAtIndex(int i) {
        Node<String> current = linkedListQueue.getFirst();
        for (int counter = 0; counter < i; counter++) {
            current = current.getNext();
        }
        return current;
    }
}
