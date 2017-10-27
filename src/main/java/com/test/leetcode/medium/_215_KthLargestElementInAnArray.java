package com.test.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Created by ben on 2017/10/25.
 */
public class _215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k > nums.length) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            pq.add(nums[i]);
            pq.poll();
        }
        return pq.poll();
    }


    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];

        int i = start, j = end;
        int pivot = nums[(i + j) / 2];

        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j--;
            }
        }

        if (k <= j) {
            return partition(nums, start, j, k);
        }

        if (k >= i) {
            return partition(nums, i, end, k);
        }

        return nums[k];
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null) return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        int i = start, j = end, pivot = nums[(start + end) / 2];
        while (i <= j) {
            while (i <= j && nums[i] > pivot) i++;
            while (i <= j && nums[j] < pivot) j--;
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //j < i
        //Case where k is dropped before j
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        //k is dropped after i
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));  //all numbers before i are less than kth
        }
        return nums[j + 1];
    }
}
