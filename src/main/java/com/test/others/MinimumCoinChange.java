package com.test.others;

/**
 * Created by ben on 2017/7/11.
 */
public class MinimumCoinChange {

    private int minCount;

    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount < coins[0]) {
            return -1;
        }

        minCount = Integer.MAX_VALUE;
        change(amount, coins, 1);
        return minCount;
    }

    public void change(int amount, int[] coins, int count) {
        for (int i = 0; i < coins.length; i++) {
            int left = amount - coins[i];
            if (left == 0) {
                if (minCount > count) {
                    minCount = count;
                }
            } else if (left < 0) {
                return;
            } else {
                change(amount - coins[i], coins, count + 1);
            }
        }
    }

    public int change1(int amount, int[] coins) {
        int[] result = new int[amount + 1];
        int[] track = new int[amount + 1];

        result[0] = 0;
        track[0] = -1;

        for (int i = 1; i <= amount; i++) {
            result[i] = Integer.MAX_VALUE - 1;
            track[i] = -1;
        }

        for (int coin : coins) {
            for (int amt = 1; amt <= amount; amt++) {
                if (coin <= amt) {
                    if (result[amt] < (result[amt - coin] + 1)) {
                        result[amt] = result[amt];
                    } else {
                        result[amt] = 1 + result[amt - coin];
                        track[amt] = coin;
                    }
                }
            }
        }

        int pos = amount;
        System.out.println(result[amount]);
        System.out.print("Conins:");
        while (pos != 0) {
            System.out.print(track[pos] + ",");
            pos -= track[pos];
        }

        System.out.println();
        return result[amount];
    }
}
