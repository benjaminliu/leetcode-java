package com.test.leetcode.easy;

/**
 * Created by ben on 2017/6/15.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }

        char[] cs = s.toCharArray();
        int aCount = 0;
        int lCount = 0;

        for (char c : cs) {
            if (c == 'A') {
                aCount++;
                if (aCount > 1) {
                    return false;
                }
            } else if (c == 'L') {
                lCount++;
                if (lCount > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
