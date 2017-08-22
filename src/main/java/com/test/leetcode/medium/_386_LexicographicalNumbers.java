package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/22.
 */
public class _386_LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                if (10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>(n);
        ans.add(1);
        for(int i = 1, prev = 1; i < n; i++) {
            if(prev * 10 <= n) {
                prev *= 10;
            }
            else {
                while(prev % 10 == 9 || prev == n) prev /= 10;
                prev++;
            }
            ans.add(prev);
            System.out.println(prev);
        }
        return ans;
    }
}
