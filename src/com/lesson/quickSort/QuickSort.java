package com.lesson.quickSort;

import com.lesson.util.ArrayGenerator;
import com.lesson.util.SortingHelper;

import java.util.Arrays;

public class QuickSort {

    public static <E extends Comparable> void sort(E[] arr) {
        sort(arr,0,arr.length - 1);
    }

    public static <E extends Comparable> void sort(E[] arr,int l,int r) {
        if (l >= r) {
            return;
        }

        int partition = partition(arr,l,r);
        sort(arr,l,partition - 1);
        sort(arr,partition + 1,r);
    }

    private static<E extends Comparable> int partition(E[] arr,int l, int r) {
        int p = l;
        for (int i = l + 1;i <= r;i++) {
            if (arr[i].compareTo(arr[l]) <= 0) {
                p++;
                swap(arr,i,p);
            }
        }

        swap(arr,l,p);
        return p;
    }

    private static <E extends  Comparable> void swap(E[] arr,int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr1 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr1);
    }
}
