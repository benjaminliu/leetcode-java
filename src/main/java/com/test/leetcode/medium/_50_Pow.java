package com.test.leetcode.medium;

/**
 * Created by ben on 2017/8/11.
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n > 0) {
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        } else {
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half / x;
            }
        }
    }

    public double myPow1(double x, int n) {
        if (n == 0) return 1;

        double temp = myPow(x, n / 2);

        if (n % 2 == 0) return temp * temp;
        else {
            if (n > 0) return (temp * temp) * x;
            else return (temp * temp) / x;
        }
    }
}
