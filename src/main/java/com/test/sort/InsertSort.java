package com.test.sort;

import java.util.Arrays;

/**
 * Created by ben on 2017/10/30.
 */
public class InsertSort {
    public void sort(int[] nums) {
        if (null == nums || nums.length < 2)
            return;

        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int left, int right) {
        if (left < 0 || right >= nums.length || left >= right)
            return;

        int temp;
        int j;

        //loop from the second number, to the last number, (every time we pick one and call it current number)
        //we compare the current number with the numbers before it, (one by one and from right to left)
        //if the former number is bigger than current number,
        //we move it to the right by 1 position, and compare to next former
        //if the former is equal or smaller the current number, (we call it smaller number)
        //means the numbers before smaller number (included) are sorted
        //then we put current number to the position next to smaller number
        for (int i = left + 1; i <= right; i++) {
            temp = nums[i];
            j = i - 1;
            while (j >= left && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 9, 1, 7, 6, 8, 0, 5};

        InsertSort sorter = new InsertSort();
        sorter.sort(nums);

        System.out.print(Arrays.toString(nums));
    }
}
