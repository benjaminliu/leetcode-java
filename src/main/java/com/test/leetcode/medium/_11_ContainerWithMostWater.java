package com.test.leetcode.medium;

/**
 * Created by ben on 2017/7/12.
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int v = (r - l) * Math.min(height[l], height[r]);
            if (v > ans) ans = v;
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }

    public int maxArea1(int[] height) {
        if (height == null)
            return 0;
        int len = height.length;
        if (len == 1 || len == 0)
            return 0;
        int left = 0;
        int right = len - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = (height[left] > height[right]) ? height[right] : height[left];
            int area = minHeight * (right - left);
            maxArea = (maxArea > area) ? maxArea : area;
            //if next left is smaller or equals to left, no need to calculate
            while (height[left] <= minHeight && left < right)
                left++;
            //if next right is smaller or equals to right, no need to calculate
            while (height[right] <= minHeight && left < right)
                right--;
        }
        return maxArea;
    }
}
