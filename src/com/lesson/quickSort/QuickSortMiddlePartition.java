package com.lesson.quickSort;

import com.lesson.util.ArrayGenerator;
import com.lesson.util.SortingHelper;

import java.util.Arrays;

public class QuickSortMiddlePartition {

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
        int mid = (r - l)/2 + l;
        swap(arr,mid,l);
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
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr1 = ArrayGenerator.generateSpecialArray(n);

        System.out.println("OrderedArray");
        SortingHelper.sortTest("QuickSortMiddlePartition",arr);

        System.out.println("SpecialArray");
        SortingHelper.sortTest("QuickSortMiddlePartition",arr1);
    }
}
