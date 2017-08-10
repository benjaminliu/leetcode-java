package com.test.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ben on 2017/8/7.
 */
public class _502_IPO {
    //time limit exceeded
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (null == Profits || null == Capital || Profits.length == 0 || Capital.length == 0 || k == 0) {
            return 0;
        }
        int len = Profits.length;
        int[] dp = new int[k];
        boolean[] visit = new boolean[len];
        int[][] values = new int[len][];
        for (int i = 0; i < len; i++) {
            values[i] = new int[2];
            values[i][0] = Capital[i];
            values[i][1] = Profits[i];
        }

        Arrays.sort(values, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        helper(values, 0, W, k, dp, visit);
        int c = W;
        for (int i = 0; i < k; i++) {
            c += dp[i];
        }
        return c;
    }

    private void helper(int[][] values, int idx, int w, int k, int[] dp, boolean[] visit) {
        int max = dp[idx];
        int maxIdx = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i][0] > w) break;
            if (visit[i]) continue;
            if (values[i][1] > max) {
                max = values[i][1];
                maxIdx = i;
            }
        }
        if (max != dp[idx]) {
            dp[idx] = max;
            visit[maxIdx] = true;
        }
        if (idx + 1 < k) {
            helper(values, idx + 1, w + max, k, dp, visit);
        }
    }

    public int findMaximizedCapital1(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < Profits.length; i++) {
            cap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!cap.isEmpty() && cap.peek()[0] <= W) {
                pro.add(cap.poll());
            }
            if (pro.isEmpty()) {
                break;
            }
            W += pro.poll()[1];
        }
        return W;
    }
}
