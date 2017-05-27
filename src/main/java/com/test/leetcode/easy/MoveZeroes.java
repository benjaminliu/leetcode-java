package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }

        int length = nums.length;
        int zeroCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i;
                for (; j < length - zeroCount - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[j] = 0;
                zeroCount++;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int h = 0, n = 0;
        while (h < nums.length && n < nums.length) {
            if (nums[n] == 0) {
                n++;
            } else {
                nums[h] = nums[n];
                h++;
                n++;
            }
        }
        for (int i = h; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {

        //将非0数字向前挪
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur] = nums[i];
                cur++;
            }
        }

        //后面的元素全部补0
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
