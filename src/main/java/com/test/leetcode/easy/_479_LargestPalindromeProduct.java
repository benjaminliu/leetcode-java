package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/24.
 */
public class _479_LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        long max = (long) Math.pow(10, n);
        long min = max / 10;
        max--;
        long res = 0;
        for (Long i = max - 1; i >= min; i--) {
            res = makePalindrome(i, max + 1);
            if (isFactorizable(res, max, min)) {
                return (int) (res % 1337);
            }
        }
        return -1;
    }

    private static long makePalindrome(long x, long scale) {
        long tmp = x * scale;
        while (x > 0) {
            scale /= 10;
            tmp += x % 10 * scale;
            x /= 10;
        }
        return tmp;
    }

    private static boolean isFactorizable(long x, long max, long min) {
        long root = (long) Math.sqrt(x);
        if (root > max || root < min) {
            return false;
        }
        long lo = root, hi = root, tmp = lo * hi;
        while (tmp != x) {
            if (tmp < x) {
                hi++;
                if (hi > max) {
                    return false;
                }
            } else {
                lo--;
                if (lo < min) {
                    return false;
                }
            }
            tmp = hi * lo;
        }
        return true;
    }


    public int largestPalindrome1(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        for (int v = max - 1; v > max / 10; v--) {
            long u = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
            for (long x = max; x * x >= u; x--) {
                if (u % x == 0) {
                    return (int) (u % 1337);
                }
            }
        }
        return 0;
    }
}