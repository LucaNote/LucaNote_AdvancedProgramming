package be.vives.ti.stack;

import be.vives.ti.adt.Stack;

public class ArrayStack implements Stack<String>
{
    private String[] stack;
    private int stackSize = 0;

    public ArrayStack(int capacity) {
        stack = new String[capacity];
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public void push(String s) {
    if (stackSize == stack.length) {
        throw new IllegalStateException("Stack is full");
    }
    stack[stackSize++] = s;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String temp = stack[stackSize - 1];
        stack[stackSize - 1] = null;
        stackSize--;

        return temp;
    }

    @Override
    public String peek() {
       if (!isEmpty()){
           return stack[stackSize -1];
       }
       return null;
    }
}
