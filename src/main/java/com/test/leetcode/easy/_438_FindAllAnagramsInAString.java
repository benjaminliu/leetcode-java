package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/8/23.
 */
public class _438_FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) return result;

        int pLen = p.length();
        int sLen = s.length();
        char base = 'a';
        int pSum = 0;
        char[] pcs = p.toCharArray();
        char[] scs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pcs) {
            pSum += c - base;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int sSum = 0;
        for (int i = 0; i < pLen; i++) {
            sSum += scs[i] - base;
        }
        if (sSum == pSum) {
            if (isAnagrams(scs, 0, pLen - 1, new HashMap(map))) {
                result.add(0);
            }
        }

        for (int i = 1; i < sLen - pLen + 1; i++) {
            sSum -= scs[i - 1] - base;
            sSum += scs[i - 1 + pLen] - base;
            if (sSum == pSum) {
                if (isAnagrams(scs, i, i + pLen - 1, new HashMap(map))) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    private boolean isAnagrams(char[] scs, int start, int end, Map<Character, Integer> map) {
        int idx = 0;
        for (; start <= end; start++) {
            Integer i = map.get(scs[start]);
            if (i == null || i == 0) {
                return false;
            }
            map.put(scs[start], i - 1);
        }
        return true;
    }

    public List<Integer> findAnagrams1(String str, String ptr) {
        List<Integer> result = new ArrayList<Integer>();
        char[] s = str.toCharArray();
        char[] p = ptr.toCharArray();
        int[] map = new int[26];
        for (char c : p) {
            map[c - 'a']++;
        }

        int end = 0, start = 0, counter = p.length;
        while (end < s.length) {
            if (map[s[end++] - 'a']-- > 0) counter--;

            while (counter == 0 && start < end) {
                if (end - start == p.length) {
                    result.add(start);
                    //start=end;
                }
                if (map[s[start++] - 'a']++ == 0) counter++;
            }
        }
        return result;
    }


    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p,
            // then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
