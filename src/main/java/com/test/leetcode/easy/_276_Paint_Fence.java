package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _276_Paint_Fence {

    //There is a fence with n posts, each post can be painted with one of the k colors.

    //You have to paint all the posts such that no more than two adjacent fence posts have the same color.

    //Return the total number of ways you can paint the fence.

    //Note:
    //n and k are non-negative integers.

    public int numWays(int n, int k) {
        if (n == 0 || k == 0 || (k == 1 && n > 2)) return 0;
        int same = 0, diff = k, last = k;
        //from the 2nd post to last post, please notice there is an = when compare to n
        for (int i = 2; i <= n; i++) {
            //current post is the same color with the last post
            same = diff;
            //current post is different from last post
            diff = last * (k - 1);
            //current post become last post by moving to next one
            last = same + diff;
        }
        return last;
    }
}
