package com.lesson.util;

import com.lesson.mergeSort.*;
import com.lesson.quickSort.*;

public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++)
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){

        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            return;
        else if(sortname.equals("InsertionSort"))
            return;
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSort2"))
            MergeSort2.sort(arr);
        else if(sortname.equals("MergeSort3"))
            MergeSort3.sort(arr);
        else if(sortname.equals("MergeSort4"))
            MergeSort4.sort(arr);
        else if(sortname.equals("MergeSortBU"))
            MergeSortBU.sort(arr);
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSortOptimizedInsertion"))
            QuickSortOptimizedInsertion.sort(arr);
        else if(sortname.equals("QuickSortOptimizedRandom"))
            QuickSortOptimizedRandom.sort(arr);
        else if(sortname.equals("QuickSortMiddlePartition"))
            QuickSortMiddlePartition.sort(arr);
        else if(sortname.equals("QuickSortOptimized2Ways"))
            QuickSortOptimized2Ways.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}