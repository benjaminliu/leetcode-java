package com.test.sort;

import java.util.Arrays;

/**
 * Created by ben on 2018/5/19.
 */
public class QuickSort {
    public void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;

        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            helper(nums, left, p - 1);
            helper(nums, p + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = right;

        //firstHigh means the first number bigger than pivot (from left)
        int firstHigh = left;

        //from the left, when we meet a number smaller than pivot,
        //we switch it with firstHigh,
        //then firstHigh point to next bigger number (compare to pivot)
        //the firstHigh may smaller than pivot, but this does not effect the result
        for (int i = left; i < right; i++) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[firstHigh];
                nums[firstHigh] = temp;
                firstHigh++;
            }
        }

        //the pivot is still at last position of the array,
        //we need to switch it with firstHigh
        //at this time, the numbers before fisrtHigh are smaller than pivot
        int temp = nums[pivot];
        nums[pivot] = nums[firstHigh];
        nums[firstHigh] = temp;
        return firstHigh;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 9, 1, 7, 6, 8, 0, 5};

        QuickSort sorter = new QuickSort();
        sorter.sort(nums);

        System.out.print(Arrays.toString(nums));
    }
}
