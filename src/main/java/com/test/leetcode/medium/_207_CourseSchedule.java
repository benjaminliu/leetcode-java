package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/10/18.
 */
public class _207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        // 先初始化图，每个赋一个空列表
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        // 根据边建立图，并计算入度
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        // 找到有向图的入口
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // 按照拓扑排序的顺序，进行广度优先搜索
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            cnt++;
            ArrayList<Integer> nexts = graph[curr];
            for (int i = 0; i < nexts.size(); i++) {
                int next = nexts.get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return cnt == numCourses;
    }


    int[] marked;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {

        int[] map = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map[i] = i;
        }

        for (int[] pre : prerequisites) {
            map[pre[0]] = pre[1];
            int p = pre[1];

            //找环
            while (p != map[p]) {
                p = map[p];

                if (p == pre[0]) {
                    return false;
                }
            }
        }

        return true;
    }
}
