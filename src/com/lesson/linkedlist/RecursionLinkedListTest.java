package com.lesson.linkedlist;

public class RecursionLinkedListTest {

    public static void main(String[] args) {
        RecursionLinkedList<Integer> linkedList = new RecursionLinkedList();

        for (int i = 0;i < 5;i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
