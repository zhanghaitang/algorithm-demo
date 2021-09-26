package com.geekbang.linkedlist.lru;

public class Node<E> {

    private E data;

    private E next;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getNext() {
        return next;
    }

    public void setNext(E next) {
        this.next = next;
    }
}
