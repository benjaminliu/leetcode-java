package com.test.sort;

/**
 * Created by ben on 2017/10/30.
 */
public class InsertSort {
    public int[] sort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        return sort(arr, 0, arr.length - 1);
    }

    public int[] sort(int[] arr, int left, int right) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        if (left < 0 || right >= arr.length || left >= right) return arr;

        int temp;
        int j;
        for (int i = left + 1; i <= right; i++) {
            temp = arr[i];
            j = i - 1;
            while (j >= left) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }
}
