package com.test.leetcode.hard;

import java.util.Arrays;

/**
 * Created by ben on 2017/5/18.
 */
public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (
                findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)
        ) / 2.0;
    }

    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key = A_start + k / 2 - 1 < A.length
                ? A[A_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                ? B[B_start + k / 2 - 1]
                : Integer.MAX_VALUE;

        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // brute-force method
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums3[nums1.length + i] = nums2[i];
        }

        Arrays.sort(nums3);
        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length / 2] + nums3[(nums3.length / 2) - 1]) / 2.0;
        } else {
            return nums3[nums3.length / 2];
        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        n = (n % 2 == 0) ? n : n + 1;
        int i = 0;
        int j = 0;
        int c = 1;

        while (c < n / 2 && i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            c++;
        }

        if (i == nums1.length) {
            while (c++ < n / 2) j++;
            int res = nums2[j];
            n = nums1.length + nums2.length;
            if (n % 2 == 0) return (res + nums2[j + 1]) / 2.0;
            return res;
        } else if (j == nums2.length) {
            while (c++ < n / 2) i++;
            int res = nums1[i];
            n = nums1.length + nums2.length;
            if (n % 2 == 0) return (res + nums1[i + 1]) / 2.0;
            return res;
        } else {
            int res = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            n = nums1.length + nums2.length;
            if (n % 2 == 0) {
                if (i == nums1.length) {
                    return (res + nums2[j]) / 2.0;
                }
                if (j == nums2.length) {
                    return (res + nums1[i]) / 2.0;
                }
                return (res + (nums1[i] < nums2[j] ? nums1[i++] : nums2[j++])) / 2.0;
            }
            return res;

        }
    }


    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 != 0) {
            return findKth(total / 2 + 1, nums1, nums2, 0, 0);
        }
        return (findKth(total / 2 + 1, nums1, nums2, 0, 0) + findKth(total / 2, nums1, nums2, 0, 0)) / 2.0;
    }

    public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length)
            return nums2[s2 + k - 1];

        if (s2 >= nums2.length)
            return nums1[s1 + k - 1];

        if (k == 1)
            return Math.min(nums1[s1], nums2[s2]);

        int half = k / 2;
        System.out.println(half);

        int m1 = s1 + half - 1;
        int m2 = s2 + half - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(k - half, nums1, nums2, m1 + 1, s2);
        }
        return findKth(k - half, nums1, nums2, s1, m2 + 1);
    }
}
