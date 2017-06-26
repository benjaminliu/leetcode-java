package com.test.leetcode.easy;

/**
 * Created by ben on 2017/6/20.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;
        int temp;

        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                temp = prices[i] - min;
                if (profit < temp) {
                    profit = temp;
                }
            }
        }
        return profit;
    }
}
