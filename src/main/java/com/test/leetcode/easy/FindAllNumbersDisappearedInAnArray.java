package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/5/27.
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        int length = nums.length;

        int[] arr = new int[length];
        for (int n : nums) {
            arr[n - 1]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0;i< length;i++) {
            if (arr[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
