package com.test.leetcode.medium;

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

        int i = 2;
        int j = 0;
        while (i <= num) {
            if (j < pow) {
                result[i] = result[index] + 1;
                index++;
                i++;
                j++;
            } else {
                pow *= 2;
                index = 0;
                j = 0;
            }
        }

        return result;
    }
}
