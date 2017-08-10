package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/7.
 */
public class _35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        if (target <= nums[0]) {
            return 0;
        }
        if (target == nums[right]) {
            return right;
        }
        if (target > nums[right]) {
            return nums.length;
        }

        int mid;
        while (left <= right) {
            if (left == right) {
                if (nums[left] < target) {
                    return left + 1;
                }
                return left;
            }

            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = right - 1;
            } else if (nums[mid] < target) {
                left = left + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchInsert1(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}
