package com.leetcode.component;

public class Sum {

    public int sum(int[] arr) {
        return sum(arr,0);
    }

    private int sum(int[] arr,int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr,l + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Sum().sum(new int[]{1,2,3,4,5}));
    }
}
