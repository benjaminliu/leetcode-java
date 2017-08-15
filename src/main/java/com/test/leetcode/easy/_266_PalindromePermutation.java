package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/15.
 */
public class _266_PalindromePermutation {

    //Given a string, determine if a permutation of the string could form a palindrome.

    // For example,
    //    "code" -> False, "aab" -> True, "carerac" -> True.

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int i : map.values()) {
            if (i == 1) {
                count++;
                if (count > 1) return false;
            } else if (i != 2) return false;
        }
        return true;
    }
}
