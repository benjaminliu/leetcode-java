package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/21.
 */
public class _547_FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return 0;
        }
        int n = M.length;
        boolean[] visited = new boolean[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, visited, i, n);
                sum++;
            }
        }
        return sum;
    }

    private void dfs(int[][] m, boolean[] visited, int i, int n) {
        for (int j = 0; j < n; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j, n);
            }
        }
    }
}
