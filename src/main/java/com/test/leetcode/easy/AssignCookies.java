package com.test.leetcode.easy;

import java.util.Arrays;

/**
 * Created by ben on 2017/5/28.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (null == g || null == s) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s[j] >= g[i])
                i++;
            j++;
        }
        return i;
    }

    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = s.length - 1, j = g.length - 1, cnt = 0;
        while (i >= 0 && j >= 0) {
            if (s[i] >= g[j]) {
                i--;
                cnt++;
                j--;
            } else {
                j--;
            }

        }
        return cnt;
    }
}
