package com.test.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ben on 2017/7/26.
 */
public class _556_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if (n < 2) {
            return -1;
        }
        Integer[] digits = new Integer[10];
        int count = 0;
        while (n > 0) {
            digits[count] = n % 10;
            n /= 10;
            count++;
        }
        int start = -1;
        for (int i = 1; i < count; i++) {
            if (digits[i] < digits[i - 1]) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return -1;
        }

        int end = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < start; i++) {
            if (digits[i] > digits[start] && digits[i] <= min) {
                min = digits[i];
                end = i;
            }
        }

        digits[end] = digits[start];
        digits[start] = min;

        Arrays.sort(digits, 0, start);

        long sum = 0;

        for (int i = count - 1; i >= start; i--) {
            sum = sum * 10 + digits[i];
        }

        for(int i = 0; i < start ;i++){
            sum = sum * 10 + digits[i];
        }
        if(sum >Integer.MAX_VALUE){
            return -1;
        }
        return (int)sum;
    }
}
