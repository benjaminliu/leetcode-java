package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/23.
 */
public class _503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int len = nums.length;
        int dLen = len * 2;
        int[] doubleNums = new int[dLen];

        for (int i = 0; i < len; i++) {
            doubleNums[i] = nums[i];
        }
        for (int i = len; i < dLen; i++) {
            doubleNums[i] = nums[i - len];
        }

        int[] result = new int[len];
        boolean found;
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            found = false;
            while (j < dLen) {
                if (doubleNums[j] > nums[i]) {
                    result[i] = doubleNums[j];
                    found = true;
                    break;
                }
                j++;
            }
            if (false == found) {
                result[i] = -1;
            }
        }

        return result;
    }

    public int[] nextGreaterElements2(int[] nums) {
        if (nums.length == 0) return nums;
        int[] result = new int[nums.length];
        result[nums.length - 1] = -1;
        if (result.length == 1) return result;
        for (int i = nums.length - 2; i >= 0; i--) {
            int k = i + 1;
            while (nums[i] >= nums[k] && result[k] != -1) {
                k = result[k];
            }
            if (nums[k] > nums[i]) result[i] = k;
            else result[i] = -1;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (result[i] != -1) continue;
            int k = (i + 1) % nums.length;
            while (nums[i] >= nums[k] && result[k] != -1) {
                k = result[k];
            }
            if (nums[k] > nums[i]) result[i] = k;
            else result[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (result[i] != -1) result[i] = nums[result[i]];
        }
        return result;
    }
}
