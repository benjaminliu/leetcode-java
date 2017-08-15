package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _278_FirstBadVersion {
    public int firstBadVersion(int n) {
        int mid;
        long start = 1;
        long end = n;
        while (start < end) {
            mid = (int) ((start + end) / 2);
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return (int) mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return (int) start;
    }

    public int firstBadVersion1(int n) {
        if (n < 1) return -1;
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }


    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
