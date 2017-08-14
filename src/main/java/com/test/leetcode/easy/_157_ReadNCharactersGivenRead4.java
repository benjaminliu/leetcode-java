package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _157_ReadNCharactersGivenRead4 {
    //Read N Characters Given Read4
    //The API: int read4(char *buf) reads 4 characters at a time from a file.
    //        The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
    //By using the read4 API, implement the function int read(char *buf, int n) that read sn characters from the file.
    //Note:
    //The read function will only be called once for each test case.

    public int read(char[] buf, int n) {
        if (buf == null || n <= 0) return 0;
        int i = 0;
        char[] temp = new char[4];
        while (n > 0) {
            int x = read4(temp);
            int j = 0;
            int k = x;
            while (n > 0 && x > 0) {
                buf[i++] = temp[j++];
                --x;
                --n;
            }
            if (k < 4) break;
        }
        return i;
    }

    private int read4(char[] buf) {
        return 4;
    }
}
