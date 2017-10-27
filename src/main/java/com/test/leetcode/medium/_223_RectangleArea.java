package com.test.leetcode.medium;


/**
 * Created by ben on 2017/10/25.
 */
public class _223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = (long) (C - A) * (D - B) + (long) (G - E) * (H - F);
        // Math.min(C, G) 表示右边边的最小的边
        // Math.max(A, E) 表示左边边的最大的边
        // 下面的减法会产生数组越介，要扩大数据范围
        long width = Math.max((long) Math.min(C, G) - (long) Math.max(A, E), 0);
        // Math.min(D, H) 表示顶边边的最小的边
        // Math.max(B, F) 表示底边边的最大的边
        long height = Math.max((long) Math.min(D, H) - (long) Math.max(B, F), 0);

        return (int) (area - width * height);
    }


    public int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sqr1 = (C - A) * (D - B);
        int sqr2 = (G - E) * (H - F);
        if (E > C || A > G || B > H || F > D)
            return sqr1 + sqr2;
        else {
            int l = Math.max(E, A);
            int r = Math.min(G, C);
            int b = Math.max(F, B);
            int t = Math.min(D, H);
            int overlap = (r - l) * (t - b);
            return sqr1 + sqr2 - overlap;
        }
    }

}
