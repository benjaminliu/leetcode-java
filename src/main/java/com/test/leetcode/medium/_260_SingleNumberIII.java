package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/5/21.
 */
public class _260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.add(n) == false) {
                set.remove(n);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int n : set) {
            res[i] = n;
            i++;
        }
        return res;
    }

    public int[] singleNumber1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return nums;
        }

        int dif = 0;
        for (int num : nums) {
            dif ^= num;
        }
        dif &= -dif;
        int[] res = new int[2];

        for (int num : nums) {
            if ((num & dif) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int temp = 3^5;

        System.out.println(Integer.toBinaryString(temp));
        System.out.println(Integer.toBinaryString(-temp));

        int a = temp & -temp;
        System.out.println(Integer.toBinaryString(a));

        System.out.println(3 & a);
        System.out.println(4 & a);
    }
}
