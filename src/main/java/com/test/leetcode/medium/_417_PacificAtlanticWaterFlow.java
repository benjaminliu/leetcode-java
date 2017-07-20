package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ben on 2017/7/20.
 */

//we want all the point that can both flow to 2 oceans
public class _417_PacificAtlanticWaterFlow {


    //
    public List<int[]> pacificAtlantic1(int[][] matrix) {
        List<int[]> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            //left side
            dfs1(matrix, pacific, Integer.MIN_VALUE, i, 0);
            //right side
            dfs1(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            //top side
            dfs1(matrix, pacific, Integer.MIN_VALUE, 0, i);
            //bot side
            dfs1(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(new int[]{i, j});
            }
        }

        print(pacific);
        System.out.println();
        print(atlantic);
        return result;
    }

    private void print(boolean[][] atlantic) {
        for (int i = 0; i < atlantic.length; i++) {
            for(int j = 0; j < atlantic[0].length;j++) {
                if(atlantic[i][j]) {
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs1(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height) return;
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs1(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }


    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic2(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs2(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs2(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs2(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs2(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs2(int[][] matrix, boolean[][] cache, int height, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || cache[i][j] || matrix[i][j] < height) {
            return;
        }
        cache[i][j] = true;
        for (int[] dir : dirs) {
            dfs2(matrix, cache, matrix[i][j], i + dir[0], j + dir[1]);
        }
    }


    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic3(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs3(matrix, i, 0, pacific, Integer.MIN_VALUE);
            dfs3(matrix, i, n - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs3(matrix, 0, j, pacific, Integer.MIN_VALUE);
            dfs3(matrix, m - 1, j, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private void dfs3(int[][] matrix, int i, int j, boolean[][] ocean, int formerHeight) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || ocean[i][j] || matrix[i][j] < formerHeight) {
            return;
        }
        ocean[i][j] = true;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            dfs3(matrix, x, y, ocean, matrix[i][j]);
        }
    }


    public List<int[]> pacificAtlantic4(int[][] matrix) {

        List<int[]> ret = new ArrayList<int[]>();
        if (matrix.length == 0) return ret;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] P = new boolean[m][n];
        boolean[][] A = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs4(matrix, P, i, 0);
            dfs4(matrix, A, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs4(matrix, P, 0, i);
            dfs4(matrix, A, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (P[i][j] && A[i][j]) ret.add(new int[]{i, j});
            }
        }
        return ret;
    }

    private int[][] pos = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs4(int[][] matrix, boolean[][] visits, int x, int y) {
        visits[x][y] = true;
        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];
            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) continue;
            if (matrix[x][y] > matrix[nx][ny]) continue;
            if (visits[nx][ny]) continue;
            dfs4(matrix, visits, nx, ny);
        }
    }
}
