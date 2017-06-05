package com.test.others;

/**
 * Created by ben on 2017/6/2.
 */
public class StringMatch_KMP {
    public int KMP(String s, String sub) {
        int m = 0;
        int n = 0;
        int[] next = new int[sub.length()];
        KMPTable(sub, next);

        while (m + n < s.length()) {
            if (s.charAt(m + n) == sub.charAt(n)) {
                if (n == sub.length() - 1) {
                    return m;
                }
                n++;
            } else {
                m = m + n - next[n];
                if (next[n] != -1) {
                    n = next[n];
                } else {
                    n = 0;
                }
            }
        }

        return -1;
    }

    private void KMPTable(String sub, int[] next) {
        int pos = 0;
        int i = 0;
        next[0] = -1;
        next[1] = 0;
        while (pos < sub.length()) {
            if (sub.charAt(pos - 1) == sub.charAt(i)) {
                i++;
                next[pos] = i;
                pos++;
            } else if (i > 0) {
                i = next[i];
            } else {
                next[pos] = 0;
                pos++;
            }
        }
    }
}
