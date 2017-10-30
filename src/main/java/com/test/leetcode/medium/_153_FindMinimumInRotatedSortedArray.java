package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/17.
 */
public class _153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        if (nums[0] < nums[len - 1]) return nums[0];

        int start = 0, end = len - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start + 1];
    }

    public int findMin1(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            //if num[mid] < num[mid - 1],  num[mid] is min No
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];

    }
}
