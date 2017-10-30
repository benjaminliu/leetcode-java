package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/18.
 */
public class _165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        int len = len1 >= len2 ? len1 : len2;

        if (version1.equals(version2)) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < len; i++) {

            String currV1 = i < len1 ? v1[i] : "0";
            String currV2 = i < len2 ? v2[i] : "0";

            int ver1 = Integer.parseInt(currV1);
            int ver2 = Integer.parseInt(currV2);

            if (ver1 > ver2) {
                result = 1;
                break;
            } else if (ver1 - ver2 < 0) {
                result = -1;
                break;
            }
        }

        return result;
    }
}
