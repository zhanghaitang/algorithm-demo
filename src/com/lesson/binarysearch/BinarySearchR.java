package com.lesson.binarysearch;

public class BinarySearchR {

    public static<E extends Comparable> int search(E[] data,E k) {
        //[l,r]
        return search(data,0,data.length-1,k);
    }


    private static<E extends Comparable> int search(E[] data,int l,int r,E k) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r -l) / 2;
        if (k.compareTo(data[mid]) == 0) {
            return mid;
        }

        if (k.compareTo(data[mid]) > 0) {
            return search(data,mid + 1,r,k);
        }

        return search(data,0,mid - 1,k);
    }
}
