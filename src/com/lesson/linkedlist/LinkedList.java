package com.lesson.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed , index must > 0 and <= size");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index;i++) {
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0,e);
    }

    public void addLast(E e) {
        add(size,e);
    }

    public E getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed , index must > 0 and < size");
        }

        Node cur = dummyHead.next;
        for (int i = 0 ; i < index;i++) {
            cur = cur.next;
        }

        return cur.e;
    }


    public E getFirst() {
        return getIndex(0);
    }

    public E getLast() {
        return getIndex(size - 1);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed , index must > 0 and < size");
        }

        Node prev = dummyHead;
        for (int i = 0;i < index;i++) {
            prev = prev.next;
        }

        Node res = prev.next;
        prev.next = res.next;
        res.next = null;
        size--;
        return res.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur);
            res.append(">");

            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
