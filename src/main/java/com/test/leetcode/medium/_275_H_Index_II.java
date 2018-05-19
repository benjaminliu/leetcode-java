package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/30.
 */
public class _275_H_Index_II {
    public int hIndex(int[] citations) {
        if (null == citations || citations.length == 0) return 0;

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
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        int lo = 0;
        int hi = citations.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int h = n - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] > h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (citations[lo] >= n - lo) {
            return n - lo;
        } else {
            return 0;
        }
    }
}
