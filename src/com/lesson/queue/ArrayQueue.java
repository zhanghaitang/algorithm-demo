package com.lesson.queue;

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> data;

    public ArrayQueue(int capacity) {
        data = new Array(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayQueue ");
        res.append("front [");
        for (int i = 0;i< data.getSize();i++) {
            res.append(data.get(i));
            if (i != data.getSize() -1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 10 ;i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue);
        arrayQueue.enqueue(20);
        System.out.println(arrayQueue);
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}
