package com.lesson.queue;


/**
 * 实现双端队列
 * @param <E>
 */
public class Dequeue<E> {

    private E[] data;
    private int front,tail,size;

    public Dequeue(int capacity) {
        data = (E[])new Object[capacity];
    }

    public Dequeue() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        front = front == 0 ? data.length - 1 : front -1;
        data[front] = e;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size;i++) {
            newData[i] = data[(i+ front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }


    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue is empty.");
        }

        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return res;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue is empty.");
        }

        tail = tail == 0 ? data.length - 1 : tail - 1;
        E res = data[tail];
        data[tail] = null;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return res;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue is empty.");
        }

        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Dequeue is empty.");
        }

        return data[tail == 0 ? data.length - 1 : tail - 1];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Dequeue front [");
        for (int i = 0;i < size;i++) {
            res.append(data[(i + front) % data.length]);

            if ((i + front + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        res.append(" front element :");
        res.append(getFront());
        res.append(" last element :");
        res.append(getLast());

        return res.toString();
    }

    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue();
        dequeue.addFront(1);
        dequeue.addFront(2);

        System.out.println(dequeue);

        dequeue.addLast(3);
        dequeue.addLast(4);
        dequeue.addLast(5);
        System.out.println(dequeue);

        dequeue.removeFront();
        System.out.println(dequeue);

        dequeue.removeLast();
        System.out.println(dequeue);
    }
}
