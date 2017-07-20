package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/7/17.
 */
public class _22_GenerateParentheses {
    private final String leftPare = "(";
    private final String rightPare = ")";

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generate(result, sb, n, n);
        return result;
    }

    //right can not be smaller the left
    private void generate(List<String> result, StringBuilder sb, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left < right) {
            if (left > 0) {
                generate(result, sb.append(leftPare), left - 1, right);
                sb.setLength(sb.length() - 1);
            }
            generate(result, sb.append(rightPare), left, right - 1);
            sb.setLength(sb.length() - 1);
        } else {
            generate(result, sb.append(leftPare), left - 1, right);
            sb.setLength(sb.length() - 1);
        }
    }
}
