package com.test.sort;

import java.util.Arrays;

/**
 * Created by ben on 2018/5/19.
 */

/**
 * use max heap to sort array asc
 */
public class HeapSort {

    public void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;
        int len = nums.length;
        //build the max heap
        for (int k = len / 2; k >= 0; k--) {
            bubbleDown(nums, k, len);
        }
        int idx = len - 1;

        //now get max number,and put it at tail.
        //and make the heap size - 1
        //and restore the new heap
        while (idx >= 0) {
            swap(nums, 0, idx--);
            bubbleDown(nums, 0, idx);
        }
    }

    //in max heap, parent should bigger than both children.
    //when not satisfied, it should swap with the bigger child.
    private void bubbleDown(int[] nums, int parent, int size) {
        int left = left(parent);
        while (left < size) {
            int right = left + 1;
            int minIdx = left;

            //if there is a right child
            if (right < size)
                //if right child is smaller than left child
                if (nums[left] < nums[right])
                    minIdx = right;

            //if parent is smaller than the smaller child, quit
            if (nums[parent] > nums[minIdx])
                break;

            //the parent swap with the smaller child
            swap(nums, parent, minIdx);
            //now the parent (moved to lower level), need to compare with its new children
            parent = minIdx;
            left = left(parent);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //1 base array use 2*n
    //0 base array use 2*n+1
    private int left(int n) {
        return 2 * n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 9, 1, 7, 6, 8, 0, 5};

        HeapSort sorter = new HeapSort();
        sorter.sort(nums);

        System.out.print(Arrays.toString(nums));
    }
}
