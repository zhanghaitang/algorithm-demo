package com.lesson.binarysearch;

public class BinarySearchC {

    public static<E extends Comparable> int search(E[] data,E k) {
        int l = 0,r = data.length-1;
        while (l <= r) {
            int mid = l + (r -l) / 2;
            if (data[mid].compareTo(k) == 0) {
                return mid;
            }

            if (data[mid].compareTo(k) > 0) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
