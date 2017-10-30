package com.test.leetcode.medium;

/**
 * Created by ben on 2017/9/29.
 */
public class _134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;
        int[] diff = new int[len];

        int sum = 0;
        for (int i = 0; i < len; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }

        if (sum < 0) return -1;

        int tempSum;

        boolean found;
        for (int i = 0; i < len; i++) {
            if (diff[i] < 0) continue;
            tempSum = 0;
            found = true;
            for (int j = i; j < i + len; j++) {
                int k = j % len;
                tempSum += diff[k];
                if (tempSum < 0) {
                    found = false;
                    i = k;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int totalGas = 0;
        int totalCost = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            totalCost += gas[i] - cost[i];
            if (totalCost < 0) {
                result = i + 1;
                totalCost = 0;
            }
        }
        if (totalGas < 0) {
            return -1;
        }
        return result;
    }
}
