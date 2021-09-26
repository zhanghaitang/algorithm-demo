package com.lesson.linkedlist;

import javafx.util.Pair;

public class RecursionLinkedList<E> {

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


    private Node head;
    private int size;

    public RecursionLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        head = add(head, index, e);
        size ++;
    }

    // 在以node为头结点的链表的index位置插入元素e，递归算法
    private Node add(Node node, int index, E e){
        if(index == 0)
            return new Node(e, node);

        node.next = add(node.next, index - 1, e);
        return node;
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

        Node node = getIndex(head,index);
        return node.e;
    }

    private Node getIndex(Node node,int index) {
        if (index == 0) {
            return node;
        }

        return getIndex(node.next,index -1);
    }

    public E getFirst() {
        return getIndex(0);
    }

    public E getLast() {
        return getIndex(size - 1);
    }

    public boolean contains(E e) {
        return contains(head,e);
    }

    private boolean contains(Node node,E e) {
        if (node == null) {
            return false;
        }
        return node.e.equals(e) ? true : contains(node.next,e);
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed , index must > 0 and < size");
        }

        Pair<Node,E> res = remove(head,index);
        head = res.getKey();
        size--;
        return res.getValue();
    }

    private Pair<Node,E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair(node.next,node.e);
        }

        Pair<Node,E> res = remove(node.next,index -1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
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
        Node cur = head;
        while (cur != null) {
            res.append(cur);
            res.append(">");

            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
