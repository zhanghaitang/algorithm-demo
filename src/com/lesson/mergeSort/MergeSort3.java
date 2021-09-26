package com.lesson.mergeSort;

import com.lesson.insertSort.InsertionSort;

import java.util.Arrays;

public class MergeSort3<E> {

    public static<E extends Comparable> void sort(E[] arr) {
        sort(arr,0,arr.length-1);
    }

    private static<E extends Comparable> void sort(E[] arr, int l, int r) {
        if (r <= l) {
            return;
        }

        if (arr.length <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int mid = l + (r -l) / 2;
        sort(arr,l,mid);
        sort(arr,mid + 1,r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr,l,mid,r);
        }
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
}
