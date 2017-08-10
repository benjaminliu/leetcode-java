package com.test.leetcode.hard;

import java.util.Stack;

/**
 * Created by ben on 2017/6/2.
 */
public class _84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) {
            return 0;
        }

        Stack<Integer> index = new Stack<>();
        int res = 0;
        int i = 0;
        int length = heights.length;
        while (i < length) {
            if (index.isEmpty() || heights[index.peek()] <= heights[i]) {
                index.push(i++);
            } else {
                int top = heights[index.pop()];
                int size = top * (index.isEmpty() ? i : i - index.peek() - 1);
                res = Math.max(res, size);
            }
        }
        while (!index.isEmpty()) {
            int top = heights[index.pop()];
            int size = top * (index.isEmpty() ? i : i - index.peek() - 1);
            res = Math.max(res, size);
        }
        return res;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return getMax(heights, 0, heights.length);
    }

    int getMax(int[] heights, int s, int e) {
        if (s + 1 >= e) {
            return heights[s];
        }
        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1]) sorted = false;
            if (heights[min] > heights[i]) min = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++) {
                max = Math.max(max, heights[i] * (e - i));
            }
            return max;
        }
        int left = (min > s) ? getMax(heights, s, min) : 0;
        int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;
        return Math.max(Math.max(left, right), (e - s) * heights[min]);
    }

    //Do push all heights including 0 height.
    // i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >= height[tp],
    // because the index on top of the stack right now is the first index left of tp with height smaller than tp's height.
    public int largestRectangleArea2(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
