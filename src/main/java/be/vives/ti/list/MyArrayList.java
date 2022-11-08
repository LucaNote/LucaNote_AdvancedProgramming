package be.vives.ti.list;

import be.vives.ti.adt.List;

public class MyArrayList implements List<String> {

    private String[] array;
    private int size;

    public MyArrayList(int capacity) {
        this.array = new String[capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String get(int i) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    @Override
    public String set(int i, String s) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        String temp = array[i];
        array[i] = s;
        return temp;
    }

    @Override
    public void add(int i, String s) throws IndexOutOfBoundsException {
        if (i > size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {
            String[] newArray = new String[2*array.length];
            for (int index = 0; index < array.length;index++) {
                newArray[index] = array[index];
            }
            array = newArray;
        }

        for (int j = size - 1; j > i; j--) {
            array[j + 1] = array[j];
        }
        array[i] = s;
        size++;
    }


    @Override
    public String remove(int i) throws IndexOutOfBoundsException {
        if (i >= size() || i < 0) {
            throw new IndexOutOfBoundsException();
        }

        String removed = array[i];
        String temp;

        for (int j = i; j < size() - 1; j++) {
            temp = array[j + 1];
            array[j] = temp;
        }

        array[size] = null;
        size--;
        return removed;
    }

    @Override
    public void add(String s) throws IndexOutOfBoundsException {
        add(size, s);
    }
}
