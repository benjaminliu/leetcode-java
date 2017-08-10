package com.test.leetcode.easy;

/**
 * Created by ben on 2017/7/11.
 */
public class _9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        char[] cs = String.valueOf(x).toCharArray();

        int start = 0;
        int end = cs.length - 1;
        while (start < end) {
            if (cs[start] != cs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome1(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        //x == rev       length is even
        //x == rev / 10  length is odd
        return (x == rev || x == rev / 10);
    }
}
