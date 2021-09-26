package com.lesson.stack;

import java.util.Random;

public class ArrayStackLinkedListStackComparison {

    private static double test(int optCount , Stack<Integer> stack) {

        Random random = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < optCount;i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount;i++) {
            stack.pop();
        }
        long end = System.nanoTime();

        return (end - start)/1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        double arrayStackTime = test(optCount,arrayStack);
        double linkedListStackTime = test(optCount,linkedListStack);

        System.out.println("ArrayStack opt count " + optCount + " time:" + arrayStackTime + "s");
        System.out.println("LinkedListStack opt count " + optCount + " time:" + linkedListStackTime + "s");
    }
}
