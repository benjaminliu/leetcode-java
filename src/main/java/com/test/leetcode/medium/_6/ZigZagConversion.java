package com.test.leetcode.medium._6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/9.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2) {
            return s;
        }

        List<Character>[] lines = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            lines[i] = new ArrayList<>();
        }

        int lineIdx = 0;
        boolean asc = true;
        char[] cs = s.toCharArray();
        int index = 0;
        while (true) {
            if (index >= cs.length) {
                break;
            }
            if (lineIdx == 0) {
                asc = true;
            } else if (lineIdx == numRows) {
                asc = false;
                lineIdx = lineIdx - 2;
                if (lineIdx < 0) {
                    lineIdx = 0;
                }
                continue;
            }
            if (asc) {
                lines[lineIdx++].add(cs[index++]);
            } else {
                lines[lineIdx--].add(cs[index++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : lines) {
            for (char c : l) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
