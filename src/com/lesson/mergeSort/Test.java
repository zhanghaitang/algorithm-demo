package com.lesson.mergeSort;

import com.lesson.util.ArrayGenerator;
import com.lesson.util.SortingHelper;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(5000000,Integer.MAX_VALUE);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        Integer[] arr4 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);
        SortingHelper.sortTest("MergeSort3",arr3);
        SortingHelper.sortTest("MergeSort4",arr4);
    }
}
