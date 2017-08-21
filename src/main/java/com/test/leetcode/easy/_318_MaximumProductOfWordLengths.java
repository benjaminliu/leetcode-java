package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/21.
 */
public class _318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (null == words || words.length == 0) return 0;

        int len = words.length;
        boolean found;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                map.put(c, 1);
            }
            for (int j = i + 1; j < len; j++) {
                found = true;
                for (char c : words[j].toCharArray()) {
                    Integer count = map.get(c);
                    if (null != count) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    int mul = words[i].length() * words[j].length();
                    if (mul > max) {
                        max = mul;
                    }
                }
            }
        }
        return max;
    }

    public int maxProduct1(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int len = words.length;
        int[] bytes = new int[len];
        for (int i = 0; i < len; i++) {
            bytes[i] = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bytes[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
}
