package com.lesson.util;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n){

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++)
            arr[i] = i;
        return arr;
    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound){

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i ++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }


    public static Integer[] generateSpecialArray(int n){
        Integer[] arr = new Integer[n];
        generateSpecialArray(arr,0,arr.length-1,0);
        return arr;
    }

    public static void generateSpecialArray(Integer[] arr,int l, int r,int value){
        if (l >= r) {
            arr[l] = value;
            return;
        }
        int mid = (r - l) / 2 + l;
        arr[mid] = value++;
        generateSpecialArray(arr,l,mid -1,value);
        generateSpecialArray(arr,mid + 1,r,value);
    }

    public static Integer[] generateSameArray(int n,int value){
        Integer[] arr = new Integer[n];
        for (int i = 0;i< n ;i++) {
            arr[i] = value;
        }
        return arr;
    }
}