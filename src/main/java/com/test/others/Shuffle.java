package com.test.others;

import java.util.Random;

/**
 * Created by ben on 2017/6/5.
 */
public class Shuffle {
    public int[] shuffle(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }
        Random r = new Random();
        for (int i = 0, length = nums.length; i < length; i++) {
            int index = r.nextInt() % (i + 1);
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
