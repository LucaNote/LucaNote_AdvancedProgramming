package be.vives.ti.adt;

public interface PriorityQueue<E> {

    int size();

    boolean isEmpty();

    void insert(E e);

    E removeMin();

    E min();
}
