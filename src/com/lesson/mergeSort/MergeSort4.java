package com.lesson.mergeSort;

import com.lesson.insertSort.InsertionSort;

import java.util.Arrays;

public class MergeSort4<E> {

    public static<E extends Comparable> void sort(E[] arr) {
        E[] temp = Arrays.copyOfRange(arr, 0 ,arr.length);
        sort(arr,0,arr.length-1,temp);
    }

    private static<E extends Comparable> void sort(E[] arr, int l, int r,E[] temp) {
        if (r <= l) {
            return;
        }

        if (arr.length <= 15) {
            InsertionSort.sort(arr);
            return;
        }

        int mid = l + (r -l) / 2;
        sort(arr,l,mid,temp);
        sort(arr,mid + 1,r,temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr,l,mid,r,temp);
        }
    }

    private static <E extends Comparable> void merge(E[] arr, int l, int mid, int r,E[] temp) {
        System.arraycopy(arr,l,temp,l,r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k < r + 1;k++) {
            if(i > mid){
                arr[k] = temp[j]; j ++;
            } else if(j > r){
                arr[k] = temp[i]; i ++;
            } else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i]; i ++;
            } else{
                arr[k] = temp[j]; j ++;
            }
        }
    }
}
