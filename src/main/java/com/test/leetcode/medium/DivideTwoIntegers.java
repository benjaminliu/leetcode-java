package com.test.leetcode.medium;

/**
 * Created by ben on 2017/6/2.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //1. check overflow: 2 ways of over flow
        // 1) 0 divisor;
        // 2) int.Minvalue/(-1)
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int negative = 1;
        if ((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = -1;
        }
        int result = 0;
        // use long type
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        while (longDividend >= longDivisor) {
            long subN = longDivisor;
            // bit operation
            for (int subCount = 1; subN <= longDividend; subCount <<= 1, subN <<= 1) {
                longDividend -= subN;
                result += subCount;
            }
        }
        if (negative == -1) {
            result = 0 - result;
        }
        return result;
    }


    public int divide1(int dividend, int divisor) {
        int flag = 1;
        if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)) {
            flag = -1;
        }
        long divdL = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);

        if (divs == 0) return Integer.MAX_VALUE;
        if (divdL == 0 || divdL < divs) return 0;

        long res = aDiv(divdL, divs);

        if (res > Integer.MAX_VALUE) { //Handle overflow.
            res = (flag == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = (int) (flag * res);
        }
        return (int) res;
    }

    public long aDiv(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        
        long sum = divisor;
        long tim = 1;
        while ((sum + sum) <= dividend) {
            sum = sum + sum;
            tim = tim + tim;
        }
        return tim + aDiv(dividend - sum, divisor);
    }
}
