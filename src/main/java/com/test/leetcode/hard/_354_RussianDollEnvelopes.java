package com.test.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ben on 2017/7/17.
 */
public class _354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0]){
                    return arr2[1] - arr1[1];
                } else{
                    return arr1[0] - arr2[0];
                }
            }
        });

        int[] dp = new int[envelopes.length];   // the tail nums of length i;
        int len = 0;
        for(int[] envelope: envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0){                  // do not contain this num, adding to tail
                index = -(index + 1);       // replace it with smaller one
            }
            dp[index] = envelope[1];
            if(index == len) len++;
        }
        return len;
    }
}
