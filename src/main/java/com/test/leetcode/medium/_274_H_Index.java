package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ben on 2017/10/30.
 */
public class _274_H_Index {
    public int hIndex(int[] citations) {
        if (null == citations || citations.length == 0) return 0;

        Arrays.sort(citations);

        int len = citations.length;
        int maxH = 0;
        for (int i = len - 1; i >= 0; i--) {
            int h = len - i;
            if (citations[i] >= h && h > maxH) {
                maxH = h;
            } else {
                break;
            }
        }
        return maxH;
    }

    public int hIndex1(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
}
