package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/7/13.
 */
public class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs1) {
            Integer temp = map.getOrDefault(c, 0);
            map.put(c, temp + 1);
        }
        int diff = len2 - len1;
        boolean found;
        for (int i = 0; i <= diff; i++) {
            if (map.get(cs2[i]) != null) {
                found = true;
                Map<Character, Integer> m = new HashMap<>(map);
                for (int j = i; j < i + len1; j++) {
                    Integer temp = m.get(cs2[j]);
                    if (temp == null) {
                        found = false;
                        i = j;
                        break;
                    }
                    if (0 == temp) {
                        found = false;
                        break;
                    }
                    m.put(cs2[j], temp - 1);
                }
                if (found == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        char[] ca1 = s1.toCharArray(), ca2 = s2.toCharArray();
        int[] cnts = new int[256];
        for (char ch : ca1) {
            cnts[ch ]++;
        }

        int left = ca1.length;
        for (int i = 0, j = 0; j < ca2.length; j++) {
            if (cnts[ca2[j]]-- > 0) left--;

            while (left == 0) {
                if (j + 1 - i == ca1.length) return true;
                if (++cnts[ca2[i++]] > 0) left++;
                //print(cnts);
            }
        }

        return false;
    }

    private void print(int[] cnts) {
        for (int i = 0; i < cnts.length; i++) {
            System.out.print(cnts[i] + ", ");
        }
        System.out.println();
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        char[] schar1 = s1.toCharArray();
        char[] schar2 = s2.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[schar1[i] - 'a']--;
            count[schar2[i] - 'a']++;
        }
        if (isAllZero(count)) return true;

        for (int j = len1; j < len2; j++) {
            count[schar2[j] - 'a']++;
            count[schar2[j - len1] - 'a']--;
            if (isAllZero(count)) return true;
        }
        return false;
    }

    private boolean isAllZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
