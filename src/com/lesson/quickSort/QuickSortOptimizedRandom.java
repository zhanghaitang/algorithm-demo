package com.lesson.quickSort;

import com.lesson.util.ArrayGenerator;
import com.lesson.util.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSortOptimizedRandom {

    public static <E extends Comparable> void sort(E[] arr) {
        Random random = new Random();
        sort(arr,0,arr.length - 1,random);
    }

    public static <E extends Comparable> void sort(E[] arr,int l,int r,Random random) {
        if (l >= r) {
            return;
        }

        int partition = partition(arr,l,r,random);
        sort(arr,l,partition - 1,random);
        sort(arr,partition + 1,r,random);
    }

    private static<E extends Comparable> int partition(E[] arr, int l, int r, Random random) {
        int randomIndex = random.nextInt(r - l + 1) + l;
        swap(arr,randomIndex,l);
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
        Integer[] arr1 = Arrays.copyOf(arr,arr.length);

        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSortOptimizedRandom",arr1);
    }
}
