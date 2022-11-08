package be.vives.ti.linkedlist;

// Het is in principe niet nodig om aanpassingen aan te brengen in deze klasse
public class DoubleLinkedList<E> {
    private final Node<E> head;
    private final Node<E> tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getFirst() {
        if(isEmpty()){
            return null;
        }
        return head.getNext();
    }

    public Node<E> getLast() {
        if(isEmpty()){
            return null;
        }
        return tail.getPrevious();
    }

    public void addLast(Node<E> nieuweNode){
        Node<E> prev = tail.getPrevious();

        nieuweNode.setNext(tail);
        nieuweNode.setPrevious(prev);

        prev.setNext(nieuweNode);
        tail.setPrevious(nieuweNode);

        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node<E> removeLast(){
        if(isEmpty()){
            return null;
        }

        Node<E> removedNode = tail.getPrevious();
        Node<E> secondLast = removedNode.getPrevious();

        secondLast.setNext(tail);
        tail.setPrevious(secondLast);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;

        return removedNode;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        Node<E> current = head.getNext();
        while(current != tail){
            sb.append(current.toString());
            sb.append("<=>");
            current = current.getNext();
        }
        sb.append("null");

        return sb.toString();
    }

    public void addAfter(Node<E> after, Node<E> nieuweNode){
        Node<E> next = after.getNext();

        nieuweNode.setNext(next);
        nieuweNode.setPrevious(after);

        after.setNext(nieuweNode);
        next.setPrevious(nieuweNode);

        size++;
    }

    public Node<E> remove(Node<E> removedNode){
        Node<E> prev = removedNode.getPrevious();
        Node<E> next = removedNode.getNext();

        prev.setNext(next);
        next.setPrevious(prev);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;
        return removedNode;
    }

    public void addFirst(Node<E> nieuweNode){
        Node<E> oldFirst = head.getNext();
        oldFirst.setPrevious(nieuweNode);
        head.setNext(nieuweNode);

        nieuweNode.setPrevious(head);
        nieuweNode.setNext(oldFirst);

        size++;
    }

    public Node<E> removeFirst(){
        if(isEmpty()){
            return null;
        }

        Node<E> removedNode = head.getNext();
        Node<E> next = removedNode.getNext();

        head.setNext(next);
        next.setPrevious(head);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;

        return removedNode;
    }

    public Node<E> search(String stationsnaam){
        Node<E> current = head.getNext();
        while(current != tail){
            if(current.getElement().equals(stationsnaam)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
}
