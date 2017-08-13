package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/19.
 */
public class _526_BeautifulArrangement {
    private int count = 0;

    public int countArrangement(int N) {
        helper(N, 1, new boolean[N + 1]);
        return count;
    }

    private void helper(int n, int level, boolean[] visited) {
        if (level > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (level % i == 0 || i % level == 0)) {
                visited[i] = true;
                helper(n, level + 1, visited);
                visited[i] = false;
            }
        }
    }

    int res = 0;

    public int countArrangement1(int N) {
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            arr[i] = i;
        }
        dfs(arr, N);
        return res;
    }

    void dfs(int[] arr, int start) {
        if (start == 0) {
            ++res;
            return;
        }
        for (int i = start; i > 0; --i) {
            swap(arr, i, start);
            if (arr[start] % start == 0 || start % arr[start] == 0) {
                dfs(arr, start - 1);
            }
            swap(arr, start, i);
        }
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
