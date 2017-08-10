package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/9.
 */
public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        final char zero = '0';
        int idx1 = len1 - 1;
        int idx2;
        int idx;
        int idxBase = 0;
        int c1;
        int c2;
        int mul;
        int toAdd;
        int increse;
        List<Integer> result = new ArrayList<>();

        for (; idx1 >= 0; idx1--) {
            c1 = num1.charAt(idx1) - zero;
            idx = idxBase++;
            idx2 = len2 - 1;
            increse = 0;
            for (; idx2 >= 0; idx2--) {
                c2 = num2.charAt(idx2) - zero;
                mul = c1 * c2 + increse;
                increse = mul / 10;
                toAdd = mul % 10;
                if (result.size() > idx) {
                    toAdd += result.get(idx);
                    if (toAdd > 9) {
                        toAdd -= 10;
                        increse++;
                    }
                    result.set(idx, toAdd);
                } else {
                    result.add(toAdd);
                }
                idx++;
            }
            if (increse > 0) {
                if (result.size() > idx) {
                    toAdd = result.get(idx) + increse;
                    if (toAdd > 9) {
                        result.set(idx, toAdd - 10);
                        if (result.size() > idx + 1) {
                            toAdd = result.get(idx + 1) + 1;
                            result.set(idx + 1, toAdd);
                        } else {
                            result.add(1);
                        }
                    } else {
                        result.set(idx, toAdd + increse);
                    }
                } else {
                    result.add(increse);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            if (!(sb.length() == 0 && pos[i] == 0))
                sb.append(pos[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
