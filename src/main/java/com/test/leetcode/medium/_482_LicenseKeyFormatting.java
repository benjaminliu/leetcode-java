package com.test.leetcode.medium;

/**
 * Created by ben on 2017/6/13.
 */
public class _482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null) {
            return S;
        }
        S = S.replace("-", "").toUpperCase();
        if (S.length() <= K) {
            return S;
        }

        final char DASH = '-';

        int dashNo = S.length() / K;
        int left = S.length() % K;
        int index = 0;
        char[] res;
        if (left == 0) {
            index = K;
            res = new char[S.length() + dashNo - 1];
        } else {
            index = left;
            res = new char[S.length() + dashNo];
        }
        int resI = 0;
        for (int i = 0, length = S.length(); i < length; i++) {
            if (index-- > 0) {
                res[resI++] = S.charAt(i);
                continue;
            }
            res[resI++] = DASH;
            index = K;
            i--;
        }

        return new String(res);
    }

    public String licenseKeyFormatting1(String S, int K) {
        char[] str = S.toCharArray();
        int len = str.length;
        int initLen = len + len / K;
        char[] ret = new char[initLen];
        int wrIdx = initLen - 1;
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = str[i];
            if (c == '-') {
                continue;
            } else {
                ret[wrIdx--] = (c <= 'z' && c >= 'a') ? (char) (c + 'A' - 'a') : c;
                cnt++;
                if (cnt == K) {
                    ret[wrIdx--] = '-';
                    cnt = 0;
                }
            }
        }
        if (++wrIdx < initLen && ret[wrIdx] == '-') {
            wrIdx++;
        }
        return new String(ret, wrIdx, initLen - wrIdx);
    }
}
