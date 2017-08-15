package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _256_PaintHouse {

    //here are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
    // The cost of painting each house with a certain color is different.
    // You have to paint all the houses such that no two adjacent houses have the same color.

    //The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    // For example,
    // costs0 is the cost of painting house 0 with color red;
    // costs1 is the cost of painting house 1 with color green,
    // and so on...
    // Find the minimum cost to paint all houses.

    //Note:
    //All costs are positive integers.
    public int minCost(int[][] costs) {

        //The basic idea is when we have painted the first i houses, and want to paint the i+1 th house,
        // we have 3 choices: paint it either red, or green, or blue.
        // If we choose to paint it red, we have the follow deduction:

        //  paintCurrentRed = min(paintPreviousGreen,paintPreviousBlue) + costs[i+1][0]

        //Same for the green and blue situation. And the initialization is set to costs[0], so we get the code:

        if (costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curR = Math.min(lastG, lastB) + costs[i][0];
            int curG = Math.min(lastR, lastB) + costs[i][1];
            int curB = Math.min(lastR, lastG) + costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(Math.min(lastR, lastG), lastB);
    }
}
