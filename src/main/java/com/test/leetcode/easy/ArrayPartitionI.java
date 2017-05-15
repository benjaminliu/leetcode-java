package com.test.leetcode.easy;

import java.util.Arrays;

/**
 * Created by ben on 2017/5/14.
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum1(int[] nums) {
        int sum = 0;
        // 是否为给定数据按从小到大排序的第奇数个值
        boolean odd = true;
        // 用来存储数据是否出现
        // 以空间换取排序的时间
        byte[] store = new byte[20001];
        // 用来标记某个整数出现次数
        // 因为可能为负数，所以需要需要一个映射
        // 这里将 [-10000, 10000] 映射为 [0, 20000]
        for (int num : nums) {
            store[num + 10000]++;
        }
        for (int i = 0; i < store.length; i++) {
            // 一个数据可能重复出现
            while (store[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                store[i]--;
            }
        }
        return sum;
    }
}
