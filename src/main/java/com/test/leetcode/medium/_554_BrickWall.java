package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/7/31.
 */
public class _554_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        if (null == wall || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum, temp;
        for (List<Integer> w : wall) {
            sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                temp = map.getOrDefault(sum, 0);
                map.put(sum, temp + 1);
            }
        }
        if(map.size() == 0){
            return wall.size();
        }
        int max = Integer.MIN_VALUE;
        for (int i : map.values()) {
            if (i > max) {
                max = i;
            }
        }

        return wall.size() - max;
    }
}
