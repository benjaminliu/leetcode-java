package com.test.others;

import com.test.leetcode.common.IntegerUtils;
import com.test.sort.InsertSort;

/**
 * Created by ben on 2017/10/30.
 */
public class Top_K_BFPRT {

    private InsertSort insertSort = new InsertSort();

    public int BFPRT(int[] arr, int left, int right, int target) {
        int pivotIndex = findMedianIdx(arr, left, right);
        int i = partition(arr, left, right, pivotIndex);

        int m = i - left + 1;

        if (m == target) return arr[i];
        if (m > target) {
            return BFPRT(arr, left, i - 1, target);
        } else {
            return BFPRT(arr, i + 1, right, target - m);
        }
    }

    private int partition(int[] arr, int left, int right, int pivotIndex) {
        IntegerUtils.swap(arr, pivotIndex, left);

        int pivot = arr[pivotIndex];
        while (left < right) {
            while (arr[right] >= pivot && left < right)
                right--;
            arr[left] = arr[right];
            while (arr[left] <= pivot && left < right)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private int findMedianIdx(int[] arr, int left, int right) {
        if (left == right) return left;

        int i;
        int n = 0;
        //每5个数分为一组，分别排序，并将改组的中位数放在最左边依次排列
        for (i = left; i < right - 5; i += 5) {
            insertSort.sort(arr, i, i + 4);
            IntegerUtils.swap(arr, left + n, i + 2);
            n++;
        }

        //求最后几个数的中位数（最后几个数不满5个的情况下）
        int num = right - i + 1;
        if (num > 0) {
            insertSort.sort(arr, i, i + num - 1);
            IntegerUtils.swap(arr, left + n, i + num / 2);
        } else {
            //arr.length % 5 == 0
            n--;
        }
        if (n == left) return left;

        return findMedianIdx(arr, left, left + n);
    }
}
