package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/11.
 */
public class _60_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] * (i + 1);
        }
        if (k > nums[n - 1]) {
            return null;
        }
        k--;
        List<Integer> ints = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            ints.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i > 0 && k > 0; i--) {
            int no = nums[i - 1];
            int idx = k / no;

            sb.append(ints.get(idx));
            ints.remove(idx);
            k = k - no * idx;
        }
        for (int i : ints) {
            sb.append(i);
        }

        return sb.toString();
    }
}
