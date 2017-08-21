package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/5/31.
 */
public class _447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int length = ((points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]));
                int count = map.containsKey(length) ? map.get(length) : 0;
                result += count * 2;
                map.put(length, count + 1);
            }
            map.clear();
        }
        return result;
    }
}
