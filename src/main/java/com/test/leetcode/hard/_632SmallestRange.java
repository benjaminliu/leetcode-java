package com.test.leetcode.hard;

import java.awt.*;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by ben on 2017/7/9.
 */
public class _632SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (a.x - b.x));
        int size = nums.size();
        int[] idxArr = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            int num = nums.get(i).get(0);
            pq.add(new Point(num, i));
            max = Math.max(max, num);
        }
        int start = -1;
        int end = -1;
        int gap = Integer.MAX_VALUE;
        while (pq.size() == size) {
            Point first = pq.poll();
            int min = first.x;
            int idx = first.y;
            if (max - min < gap) {
                gap = max - min;
                start = min;
                end = max;
            }

            if (++idxArr[idx] < nums.get(idx).size()) {
                first.x = nums.get(idx).get(idxArr[idx]);
                pq.add(first);
                max = Math.max(max, first.x);
            }
        }
        return new int[]{start, end};
    }
}
