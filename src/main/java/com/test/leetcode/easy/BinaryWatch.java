package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/5/31.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 8) {
            return new ArrayList<>();
        }
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    private List<String> res = new ArrayList<String>();

    public List<String> readBinaryWatch1(int num) {
        readBinaryWatch(num, 0, 0, 0, 0);
        return res;
    }

    private void readBinaryWatch(int num, int hour, int hi, int min, int mi) {
        if (hour >= 12 || min >= 60)
            return;
        if (num == 0) {
            res.add(String.format("%d:%02d", hour, min));
            return;
        }
        for (int i = hi; i < 4; i++) {
            readBinaryWatch(num - 1, hour + (1 << i), i + 1, min, mi);
        }
        for (int i = mi; i < 6; i++) {
            readBinaryWatch(num - 1, hour, 6, min + (1 << i), i + 1);
        }
    }

    public List<String> readBinaryWatch2(int num) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int total = countDigits(i) + countDigits(j);
                if (total == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }

    public int countDigits(int num) {
        int result = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                result++;
            }

            num >>= 1;
        }

        return result;
    }
}
