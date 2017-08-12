package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/12.
 */
public class _205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if (s == null && t == null) return true;

        if (s.length() != t.length()) return false;

        if (s.length() == 0 && t.length() == 0) return true;

        if (s.length() == 1 && t.length() == 1) return true;

        if (s == null || t == null) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;

        int len = s.length();
        char c1;
        char c2;
        int i1;
        int i2;

        //store last same char's position
        //保存相同字符 上次出现的位置，如果上次出现的位置不同，返回false
        for (int i = 0; i < len; i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            i1 = map1.getOrDefault(c1, -1);
            i2 = map2.getOrDefault(c2, -1);
            if (i1 == -1 && i2 == -1) {
                map1.put(c1, i);
                map2.put(c2, i);
            } else {
                //is last same char position is not equal, return false
                if (i1 != i2) return false;

                //We don't need remember last time's position, only the first time is ok
//                map1.put(c1, i1);
//                map2.put(c2, i2);
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        int[] m = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    //上次出现的位置加1
    public static boolean isIsomorphic2(String s, String t) {
        int[] pos_s = new int[256];
        int[] pos_t = new int[256];
        char[] word_s = s.toCharArray();
        char[] word_t = t.toCharArray();

        for (int i = 0; i < word_s.length; ++i) {
            if (pos_s[word_s[i]] != pos_t[word_t[i]]) return false;
            pos_s[word_s[i]] = i + 1;
            pos_t[word_t[i]] = i + 1;
        }
        return true;
    }
}
