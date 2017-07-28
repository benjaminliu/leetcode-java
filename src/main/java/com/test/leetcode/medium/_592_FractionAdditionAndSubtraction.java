package com.test.leetcode.medium;

import com.test.leetcode.common.IntegerUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/5/22.
 */
public class _592_FractionAdditionAndSubtraction {

    private static final char ZERO = '0';

    public class Fractoin {
        private int numerator;
        int denominator;
        boolean positive;

        public void setNumerator(int numerator) {
            if (!positive) {
                this.numerator = -1 * numerator;
            } else {
                this.numerator = numerator;
            }
        }

        public void setPositive(boolean positive) {
            this.positive = positive;
        }

        public int getNumerator() {
            return numerator;
        }

        public Fractoin() {
            this(true);
        }

        public Fractoin(boolean positive) {
            this.positive = positive;
        }

        @Override
        public String toString() {
            return this.getNumerator() + "/" + this.denominator;
        }
    }

    public String fractionAddition(String expression) {
        if (expression == null || expression.length() < 7) {
            return expression;
        }
        char[] cs = expression.toCharArray();
        int length = cs.length;
        Map<Integer, Fractoin> map = new HashMap<>();
        char temp;
        int numStart = 0;
        Fractoin tempF = null;
        int num;
        int i = 0;
        for (; i < length; i++) {
            temp = cs[i];
            if (temp == '-' || temp == '+') {
                //取分母
                if (tempF != null) {
                    num = getNum(cs, numStart, i);
                    tempF.denominator = num;
                    addMapItem(map, tempF);
                }
                if (temp == '-') {
                    tempF = new Fractoin(false);
                } else {
                    tempF = new Fractoin();
                }
                numStart = i + 1;
            } else if (temp == '/') {
                //取分子
                if (tempF == null) {
                    tempF = new Fractoin();
                }
                num = getNum(cs, numStart, i);
                tempF.setNumerator(num);
                numStart = i + 1;
            }
        }

        //add last fraction
        tempF.denominator = getNum(cs, numStart, i);
        addMapItem(map, tempF);

        List<Fractoin> valid = new ArrayList<>(map.size());
        int lcm = 1;
        for (Fractoin f : map.values()) {
            if (f.numerator != 0) {
                lcm = IntegerUtils.getLcm(lcm, f.denominator);
                valid.add(f);
            }
        }
        int sum = 0;
        for (Fractoin f : valid) {
            sum += f.getNumerator() * (lcm / f.denominator);
        }

        int gcd = Math.abs(IntegerUtils.getGcd(sum, lcm));
        Fractoin result = new Fractoin();
        result.numerator = sum / gcd;
        result.denominator = lcm / gcd;

        return result.toString();
    }

    private void addMapItem(Map<Integer, Fractoin> map, Fractoin tempF) {
        Fractoin has = map.get(tempF.denominator);
        if (has != null) {
            tempF.numerator = has.getNumerator() + tempF.getNumerator();
        }
        map.put(tempF.denominator, tempF);
    }

    private int getNum(char[] cs, int numStart, int i) {
        double num = 0;
        for (int j = numStart; j < i; j++) {
            num = cs[j] - ZERO + num * Math.pow(10, j - numStart);
        }
        return (int) num;
    }

}
