package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/24.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        char temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}
