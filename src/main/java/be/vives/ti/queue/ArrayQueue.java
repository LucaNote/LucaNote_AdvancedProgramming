package be.vives.ti.queue;

import be.vives.ti.adt.Queue;

public class ArrayQueue implements Queue<String> {

        private String[] queue;
        private int size, front;



    public ArrayQueue(int capacity){
        this.queue = new String[capacity];
        this.size = this.front = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(String s) {
        if (size == queue.length){
            throw new IllegalStateException("Queue is full");
        }
        queue[(front + size) % queue.length] = s;
        size++;
    }


    @Override
    public String first() {
        if(isEmpty()){
            return null;
        }
        return queue[front];
    }

    @Override
    public String dequeue() {
        if (isEmpty()){
            return null;
        }
        String temp = queue[front];
        front =(front + 1)% queue.length;

        size--;
       return temp;
    }
}
