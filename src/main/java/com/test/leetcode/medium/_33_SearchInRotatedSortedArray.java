package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/7.
 */
public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            //only 1 pivot, so, one part is sorted, the other part is not sorted,
            //(if mid is the pivot, two part are sorted, but it does't matters)
            //only check if target is in the sorted part.
            //if not, ignore the sorted part.
            //if yes, ignore the unsorted part.
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int pivot = l;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int realm = (mid + pivot) % nums.length;
            if (nums[realm] == target) {
                return realm;
            }
            if (nums[realm] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
