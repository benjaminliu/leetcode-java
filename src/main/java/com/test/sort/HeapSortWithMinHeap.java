package com.test.sort;

import com.test.datastructure.MinHeap;

import java.util.Arrays;

/**
 * Created by ben on 2018/5/19.
 */
public class HeapSortWithMinHeap {
    public void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;

        MinHeap minHeap = new MinHeap();
        minHeap.buildMinHeap(nums);

        for (int i = 0, len = nums.length; i < len; i++) {
            nums[i] = minHeap.extractMin();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 9, 1, 7, 6, 8, 0, 5};

        HeapSortWithMinHeap sorter = new HeapSortWithMinHeap();
        sorter.sort(nums);

        System.out.print(Arrays.toString(nums));
    }
}
