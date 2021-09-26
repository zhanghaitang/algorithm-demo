package com.leetcode;

public class BinarySearch704 {

    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    private int search(int[] data,int l,int r,int k) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r -l) / 2;
        if (k == data[mid]) {
            return mid;
        }

        if (k > data[mid]) {
            return search(data,mid + 1,r,k);
        }

        return search(data,0,mid - 1,k);
    }
}
