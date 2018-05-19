package com.test.leetcode.medium;

/**
 * Created by ben on 2017/11/9.
 */
public class _306_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() == 0) return false;
        return helper(num, 0, 0, 0, 0);
    }

    private boolean helper(String num, int index, int first, int second, int count) {
        if (index == num.length()) return count >= 3;

        int n = 0;
        for (; index < num.length(); index++) {
            n = n * 10 + num.charAt(index) - '0';
            if (count >= 2) {
                if (first + second == n) {
                    index++;
                    break;
                }
            } else if (helper(num, index + 1, second, n, count + 1))
                return true;
            if (n == 0)
                return false;
        }

        if (first + second == n)
            return helper(num, index, second, n, count + 1);
        return false;
    }


    public boolean isAdditiveNumber1(String num) {

        int L = num.length();

        //确定第一个数，最终用num.subStr(0,i)来确定第一个数，所以i可以用来标示第一个数的长度，
        //但是下标i不包含在第一个数中
        for (int i = 1; i <= (L - 1) / 2; i++) {

            //如果长度大于等于2，则不能以0开头
            if (num.startsWith("0") && i >= 2) break;

            //确定第二个数，第一个数用num.subStr(i,j),包括i，不包括j，所以长度为j-i,
            //第三个数从下标j开始，长度最长为L-1-j+1，即L-j
            for (int j = i + 1; (L - j) >= i && (L - j) >= j - i; j++) {
                if (num.charAt(i) == '0' && j - i >= 2) break;

                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));

                if (isAdditive(num.substring(j), num1, num2)) {
                    return true;
                }
            }
        }


        return false;
    }

    //判断由num1,num2和后续的字串能否构成加法序列
    public boolean isAdditive(String remain, long num1, long num2) {

        if (remain.equals("")) return true;

        long sum = num1 + num2;

        String sumStr = "" + sum;
        if (!remain.startsWith(sumStr)) return false;

        return isAdditive(remain.substring(sumStr.length()), num2, sum);
    }
}
