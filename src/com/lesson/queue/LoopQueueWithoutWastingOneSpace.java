package com.lesson.queue;

public class LoopQueueWithoutWastingOneSpace<E> implements Queue<E>{

    private E[] data;

    private int size;

    private int front;

    private int tail;


    public LoopQueueWithoutWastingOneSpace(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueWithoutWastingOneSpace() {
        this(10);
    }

    private int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size = size + 1;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size;i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        E result = data[front];
        data[front] = null;
        front = (front +1) % data.length;
        size--;
        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueueWithoutWastingOneSpace<Integer> loopQueueWithoutWastingOneSpace = new LoopQueueWithoutWastingOneSpace();
        for (int i = 0; i< 10;i++) {
            loopQueueWithoutWastingOneSpace.enqueue(i);
        }

        System.out.println(loopQueueWithoutWastingOneSpace);
        loopQueueWithoutWastingOneSpace.enqueue(10);
        System.out.println(loopQueueWithoutWastingOneSpace);
    }
}
