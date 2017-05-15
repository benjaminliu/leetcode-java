package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/5/14.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        if(candies == null){
            throw  new IllegalArgumentException("Empty candies");
        }
        if(candies.length %2 == 1){
            throw  new IllegalArgumentException("Odd candies");
        }

        Set<Integer> set = new HashSet<Integer>();
        int length = candies.length;
        for (int c : candies) {
            set.add(c);
        }
        if (set.size() > length / 2) {
            return length / 2;
        }
        return set.size();
    }

    public int distributeCandies2(int[] candies) {
        if(candies == null){
            throw  new IllegalArgumentException("Empty candies");
        }
        if(candies.length %2 == 1){
            throw  new IllegalArgumentException("Odd candies");
        }

        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        int length = candies.length;
        int half = length / 2;
        for (int c : candies) {
            if (set.add(c)) {
                count++;
                if (count >= half) {
                    break;
                }
            }
        }
        return count;
    }
}
