package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/25.
 */
public class _611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (null == nums || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int len = nums.length;
        int sum, k;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                sum = nums[i] + nums[j];
                k = j + 1;
                while (k < len && nums[k++] < sum) {
                    count++;
                }
            }
        }
        return count;
    }

    public int triangleNumber1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
