package com.test.leetcode;

/**
 * Created by ben on 2017/5/15.
 */
public class CountingBits {
    //[0,1,1,2,2]
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }

        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int pow = 2;
        int index = 0;

        for (int i = 2; i <= num; i++) {
            if (i <= Math.pow(2, pow)) {
                result[i] = result[index] + 1;
                index++;
            } else {
                pow++;
                index = 0;
            }
        }

        return result;
    }
}
