package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/10.
 */
public class _17_LetterCombinationsOfAPhoneNumber {
    private final String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final char zero = '0';
    private List<String> result;
    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() < 1) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        int length = digits.length();
        char[] cs = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        combination(cs, sb, 0, length, table);
        return result;
    }
    private void combination(char[] cs, StringBuilder sb, int idx, int length, String[] table) {
        String s = table[cs[idx] - zero];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == length) {
                result.add(sb.toString());
                sb.setLength(sb.length() - 1);
                continue;
            }
            combination(cs, sb, idx + 1, length, table);
            sb.setLength(sb.length() - 1);
        }
    }
}
