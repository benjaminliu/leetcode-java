package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/13.
 */
public class _53_MaximumSubarray {

    //已知一个数组A[n]及其最大子数组max_subarray(A[n])，我们添加一个元素A[n+1]进去。则有三种可能的情况：
    //1. 添加进去元素的数组A[n+1]不影响A[n]的最大子数组。
    //2. 单独的A[n+1]
    //3. 以max_subarray(A[n])和A[n+1]以及两者之间的元素组合起来生成的数组。
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        int len = nums.length;
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < len; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = nums[i];
            } else {
                maxEndingHere += nums[i];
            }
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                temp[i] = nums[i];
            } else {
                if (temp[i - 1] >= 0) {
                    temp[i] = temp[i - 1] + nums[i];
                } else {
                    temp[i] = nums[i];
                }
            }
        }
        int max = temp[0];
        for (int i = 0; i < len; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }
}
