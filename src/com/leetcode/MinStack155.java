package com.leetcode;

public class MinStack155 {

    private Integer[] data;

    private int size;

    private Integer[] min;

    public MinStack155() {
        data = new Integer[100];
        min = new Integer[100];
        size = 0;
    }

    public void push(int x) {
        if (data.length == size) {
            resize(data.length * 2);
        }
        data[size] = x;

        if (size == 0 || x < min[size-1]) {
            min[size] = x;
        } else {
            min[size] = min[size - 1];
        }

        size++;
    }

    private void resize(int capacity) {
        Integer[] newData = new Integer[capacity];
        for (int i = 0;i < size;i++) {
            newData[i] = data[i];
        }
        data = newData;

        Integer[] newMin = new Integer[capacity];
        for (int i = 0;i < size;i++) {
            newMin[i] = min[i];
        }
        min = newMin;
    }

    public void pop() {
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        data[size-1] = null;
        min[size-1] = null;
        size--;
    }

    public int top() {
        return data[size-1];
    }

    public int getMin() {
        return min[size-1];
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
