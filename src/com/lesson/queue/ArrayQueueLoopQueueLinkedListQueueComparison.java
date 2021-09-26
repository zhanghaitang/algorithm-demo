package com.lesson.queue;

import java.util.Random;

public class ArrayQueueLoopQueueLinkedListQueueComparison {

    private static double testQueue(int optCount ,Queue<Integer> queue) {

        Random random = new Random();
        long start = System.nanoTime();
        for (int i = 0; i < optCount;i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount;i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();

        return (end - start)/1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        double arrayQueueTime = testQueue(optCount,arrayQueue);
        double loopQueueTime = testQueue(optCount,loopQueue);
        double linkedListQueueTime = testQueue(optCount,linkedListQueue);

        System.out.println("ArrayQueue opt count " + optCount + " time:" + arrayQueueTime + "s");
        System.out.println("LoopQueue opt count " + optCount + " time:" + loopQueueTime + "s");
        System.out.println("LinkedListQueue opt count " + optCount + " time:" + linkedListQueueTime + "s");
    }
}
