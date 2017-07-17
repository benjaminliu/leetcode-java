package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/17.
 */
public class _34_SearchForARange {


    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int ll = 0;
        int lr = nums.length - 1;
        while (ll <= lr) {
            int m = (ll + lr) / 2;
            if (nums[m] < target) {
                ll = m + 1;
            } else {
                lr = m - 1;
            }
        }
        int rl = 0;
        int rr = nums.length - 1;
        while (rl <= rr) {
            int m = (rl + rr) / 2;
            if (nums[m] <= target) {
                rl = m + 1;
            } else {
                rr = m - 1;
            }
        }
        if (ll <= rr) {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }

    public int[] searchRange1(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int l = mid;
                int r = mid;
                while (l - 1 >= 0 && nums[l - 1] == target) {
                    l -= 1;
                }
                while (r + 1 < nums.length && nums[r + 1] == target) {
                    r += 1;
                }
                return new int[]{l, r};
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return new int[]{-1, -1};
    }


}
