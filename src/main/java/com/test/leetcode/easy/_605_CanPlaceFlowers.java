package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/31.
 */
public class _605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (null == flowerbed || flowerbed.length == 0) return false;
        if (n == 0) return true;
        if (n > (flowerbed.length / 2) + 1) return false;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) return true;
            return false;
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            flowerbed[0] = 1;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 1) continue;
            if (flowerbed[i - 1] == 1) continue;
            if (flowerbed[i + 1] == 1) continue;
            n--;
            flowerbed[i] = 1;
        }

        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) n--;

        if (n < 1) return true;
        return false;
    }
}
