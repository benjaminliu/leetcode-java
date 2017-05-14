package com.test.leetcode.problems;

import static java.lang.System.out;

/**
 * Created by ben on 2017/5/14.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (z >> i) & 1;
        }
        return result;
    }

    public int hammingDistance1(int x, int y) {
        int res = 0, exc = x ^ y;
        out.println(Integer.toBinaryString(exc));
        while (exc != 0) {
            ++res;
            exc &= (exc - 1);
            out.println(Integer.toBinaryString(exc));

        }
        return res;
    }
}
