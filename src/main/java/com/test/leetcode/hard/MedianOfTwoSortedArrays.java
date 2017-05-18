package com.test.leetcode.hard;

/**
 * Created by ben on 2017/5/18.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (n2 == 0) {
            return ((double) nums1[(n1 - 1) / 2] + (double) nums2[n1 / 2]) / 2;
        }
        int lo = 0;
        int hi = n2 * 2;

        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;
            int mid1 = n1 + n2 - mid2;
            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double r1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double r2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (l1 > l2) {
                lo = mid2 + 1;
            } else if (l2 > r1) {
                hi = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2));
            }
        }
        return -1;
    }


}
