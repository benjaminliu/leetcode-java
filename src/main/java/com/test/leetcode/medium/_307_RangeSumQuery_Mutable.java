package com.test.leetcode.medium;

/**
 * Created by ben on 2017/11/9.
 */

//binary indexed tree
public class _307_RangeSumQuery_Mutable {

    int[] bit;
    int n;
    int[] nums;

    public _307_RangeSumQuery_Mutable(int[] nums) {
        n = nums.length;
        bit = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }


    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        while (i <= n) {
            bit[i] += diff;

            i += (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }

    public int sum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }
}
