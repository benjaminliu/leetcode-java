package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/7.
 */
public class _33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return -1;
        }
        int left = nums[0];
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid])
        }
    }
}
