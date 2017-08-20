package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/20.
 */
public class _319_BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public int bulbSwitch1(int n) {

        int i = 1;
        while (i * i <= n) {
            i++;
        }

        return i - 1;
    }
}
