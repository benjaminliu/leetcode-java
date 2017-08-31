package com.test.leetcode.easy;

import java.util.Arrays;

/**
 * Created by ben on 2017/8/31.
 */
public class _628_MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        if (null == nums || nums.length < 3) return 0;

        Arrays.sort(nums);
        int len = nums.length;
        int max1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int max2 = nums[0] * nums[1] * nums[len - 1];
        return Math.max(max1, max2);
    }

    public int maximumProduct1(int[] nums) {
        int[] min = new int[3];
        int[] max = new int[3];
        for (int i = 0; i < 3; i++) {
            min[i] = 1000;
            max[i] = -1000;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < min[2]) {
                if (n < min[1]) {
                    if (n < min[0]) {
                        min[2] = min[1];
                        min[1] = min[0];
                        min[0] = n;
                    } else {
                        min[2] = min[1];
                        min[1] = n;
                    }
                } else {
                    min[2] = n;
                }
            }
            if (n > max[2]) {
                if (n > max[1]) {
                    if (n > max[0]) {
                        max[2] = max[1];
                        max[1] = max[0];
                        max[0] = n;
                    } else {
                        max[2] = max[1];
                        max[1] = n;
                    }
                } else {
                    max[2] = n;
                }
            }
        }
        if (min[1] >= 0)
            return max[0] * max[1] * max[2];
        else if (max[0] < 0)
            return min[0] * min[1] * min[2];
        else return Math.max(max[0] * max[1] * max[2], max[0] * min[0] * min[1]);
    }
}
