package com.lesson.queue;

public class LoopQueueWithoutSizeMember<E> implements Queue<E>{

    private E[] data;

    private int front;

    private int tail;


    //因为没有size计数，当front = tail 时候不知道是空队列还是满队列，所以这里浪费一个空间
    public LoopQueueWithoutSizeMember(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueWithoutSizeMember() {
        this(10);
    }

    private int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return tail >= front ? tail - front : (getCapacity() - front + tail);
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < getSize();i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        data = newData;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        E result = data[front];
        data[front] = null;
        front = (front +1) % data.length;
        if (getSize() <= getCapacity() / 4 && getCapacity() / 2 != 0) {
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
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(data[(i + front) % data.length]);
            if ((i + front + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        LoopQueueWithoutSizeMember<Integer> loopQueueWithoutWastingOneSpace = new LoopQueueWithoutSizeMember();
        for (int i = 0; i< 10;i++) {
            loopQueueWithoutWastingOneSpace.enqueue(i);
        }

        System.out.println(loopQueueWithoutWastingOneSpace);
        loopQueueWithoutWastingOneSpace.enqueue(10);
        System.out.println(loopQueueWithoutWastingOneSpace);
    }
}
