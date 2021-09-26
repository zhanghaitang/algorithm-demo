package com.lesson.mergeSort;

import com.lesson.util.ArrayGenerator;
import com.lesson.util.SortingHelper;

import java.util.Arrays;

public class MergeSortBU<E> {

    public static<E extends Comparable> void sort(E[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static<E extends Comparable> void sort(E[] arr, int l, int r) {

    }

    private static <E extends Comparable> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l ,r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k < r + 1;k++) {
            if(i > mid){
                arr[k] = temp[j - l]; j ++;
            } else if(j > r){
                arr[k] = temp[i - l]; i ++;
            } else if(temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l]; i ++;
            } else{
                arr[k] = temp[j - l]; j ++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(1000000,Integer.MAX_VALUE);
        SortingHelper.sortTest("MergeSortBU",arr);
    }
}
