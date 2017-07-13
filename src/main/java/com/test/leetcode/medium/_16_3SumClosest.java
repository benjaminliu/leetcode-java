package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/13.
 */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        int start, end;
        int len = nums.length;
        int closest = Integer.MAX_VALUE;
        int sum;
        int diff;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            start = i + 1;
            end = len - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                diff = Math.abs(target - sum);
                if (diff == 0) {
                    return target;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closest;
    }

    public int threeSumClosest1(int[] nums, int target) {

        int len = nums.length;
        if (len == 3)
            return nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        int tLow, tHigh;
        tLow = target;
        tHigh = target + 1;

        while (true) {
            if (checkContains(nums, tLow))
                return tLow;
            if (checkContains(nums, tHigh))
                return tHigh;
            tLow--;
            tHigh++;
        }
    }

    private boolean checkContains(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int a, b, c;
            int low = i + 1, high = len - 1;
            a = nums[i];

            while (low < high) {
                b = nums[low];
                c = nums[high];
                if (a + b + c > target) {
                    high--;
                } else if (a + b + c < target) {
                    low++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
