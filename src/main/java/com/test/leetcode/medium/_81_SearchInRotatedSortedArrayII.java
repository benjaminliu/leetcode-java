package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/7.
 */
public class _81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] == nums[mid]) {
                //if nums[left] == nums[mid], we can not tell which part is sorted.
                //so just increase left
                left++;
            } else if (nums[right] == nums[mid]) {
                //if nums[right] == nums[mid], we can not tell which part is sorted.
                //so just decrease right
                right--;
            }
        }

        return false;
    }
}
