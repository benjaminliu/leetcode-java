package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/31.
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k < 1) {
            return s;
        }

        int length = s.length();
        int times = length / k;
        int left = length % k;
        boolean needReverse = true;
        int start;
        int end;
        char[] arr = s.toCharArray();
        for (int i = 0; i < times; i++) {
            if (needReverse) {
                start = i * k;
                end = start + k - 1;
                reverseString(arr, start, end);
            }
            needReverse = !needReverse;
        }
        if (times % 2 == 0 && left > 0) {
            start = times * k;
            end = length - 1;
            reverseString(arr, start, end);
        }
        return new String(arr);
    }

    public String reverseStr1(String s, int k) {
        char[] result = s.toCharArray();
        int current = 0, len = s.length();
        while (current < len) {
            int perv = Math.min(len - 1, current + k - 1);
            reverseString(result, current, perv);
            current += 2 * k;
        }
        return String.valueOf(result);
    }

    public void reverseString(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
