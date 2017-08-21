package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/20.
 */
public class _540_SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 3) return nums[0] == nums[1] ? nums[2] : nums[0];

        return helper(nums, 0, nums.length - 1, nums.length);
    }

    private int helper(int[] nums, int start, int end, int len) {
        if (start <= end) {
            int mid = (end - start) / 2 + start;
            boolean isEven = mid % 2 == 1;
            if (mid == 0) {
                return nums[mid];
            }
            if (mid + 1 == len) {
                return nums[mid];
            }

            if (isEven) {

                if (nums[mid] == nums[mid - 1]) {
                    return helper(nums, mid + 1, end, len);
                }
                if (nums[mid] == nums[mid + 1]) {
                    return helper(nums, start, mid - 1, len);
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    return helper(nums, start, mid - 1, len);
                }
                if (nums[mid] == nums[mid + 1]) {
                    return helper(nums, mid + 1, end, len);
                }
            }
            return nums[mid];
        }
        return -1;
    }


    public int singleNonDuplicate1(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) end = mid;
            else start = mid + 2;
        }
        return nums[start];
    }
}
