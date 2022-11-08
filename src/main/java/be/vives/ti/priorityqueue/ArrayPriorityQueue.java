package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;

public class ArrayPriorityQueue implements PriorityQueue<Integer> {

    private Integer[] priorityQueue;
    private int size;
    private int last;

    public ArrayPriorityQueue(int capacity){
        this.priorityQueue = new Integer[capacity];
        this.size=0;
        this.last = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(Integer integer) {
        if (size == priorityQueue.length){
            throw new IllegalStateException();
        }
        int i = size - 1;
        while(i >= 0 && priorityQueue[i] < integer){
            priorityQueue[i+1] = priorityQueue[i];
            i--;
        }
       // priorityQueue[i]
    }

    @Override
    public Integer removeMin() {
        if (isEmpty()){
            return null;
        }
        return null;
    }

    @Override
    public Integer min() {
        return priorityQueue[size-1];
    }
}
