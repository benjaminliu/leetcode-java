package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/19.
 */
public class _93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        return true;
    }

    public List<String> restoreIpAddresses1(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        backtracking(res, s, 0, "", 4);
        return res;
    }

    private void backtracking(List<String> res, String s, int pos, String temp, int parts) {
        if (s.length() - pos > parts * 3 || s.length() - pos < parts) {
            return;
        }
        if (parts == 0) {
            res.add(new String(temp));
            return;
        }
        int num = 0, digit = 0;
        for (int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            num = 10 * num + ch - '0';
            digit++;
            temp += ch;
            if (num > 255 || (digit > 1 && num < 10)) {
                break;
            }
            if (parts > 1) {
                backtracking(res, s, i + 1, temp + '.', parts - 1);
            } else {
                backtracking(res, s, i + 1, temp, parts - 1);
            }
        }
    }
}
