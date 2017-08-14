package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        if (null == nums || nums.length == 0) return;

        int len = nums.length;
        if (k > len) {
            k = k % len;
        }
        int j;
        int[] tails = new int[k];
        j = 0;
        for (int i = len - k; i < len; i++) {
            tails[j++] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            j = len - 1 - i;
            while (j - k >= 0) {
                nums[j] = nums[j - k];
                j -= k;
            }
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tails[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        if (k <= 0) return;
        k = k % len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int t = nums[s];
            nums[s] = nums[e];
            nums[e] = t;
            s++;
            e--;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
