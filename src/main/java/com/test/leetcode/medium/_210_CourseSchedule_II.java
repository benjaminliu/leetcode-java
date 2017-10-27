package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by ben on 2017/10/23.
 */
public class _210_CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) {
            return new int[0];
        }
        List<List<Integer>> graph = getGraph(prerequisites, numCourses);
        // 0 -- unvisited; 1 -- being visited; 2 -- visited.
        int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(order, graph, visited, i)) {  // cycle exists
                return new int[0];
            }
        }
        int[] res = new int[order.size()];
        int idx = 0;
        for (Integer num : order) {
            res[idx++] = num;
        }
        return res;
    }

    private List<List<Integer>> getGraph(int[][] prerequisites, int numCourses) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int c0 = prerequisites[i][0];
            int c1 = prerequisites[i][1];
            graph.get(c0).add(c1);
        }
        return graph;
    }

    private boolean hasCycle(List<Integer> order, List<List<Integer>> graph, int[] visited, int cur) {
        if (visited[cur] == 2) {
            return false;
        } else if (visited[cur] == 1) {
            return true;
        }
        visited[cur] = 1;  // current vertex is being visited, that is, in recursion stack
        for (Integer i : graph.get(cur)) {
            if (hasCycle(order, graph, visited, i)) {
                return true;
            }
        }
        // cur vertex and its subgraph visited;
        visited[cur] = 2;
        // pop it out of recursion stack; add it to the front of topological sequence
        order.add(cur);
        return false;
    }


    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] incEdge = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        initializeGraph(incEdge, graph, prerequisites);
        return BFS(incEdge, graph);
    }

    private void initializeGraph(int[] incEdge, List<List<Integer>> graph, int[][] prerequisites) {
        int n = incEdge.length;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            incEdge[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }
    }

    private int[] BFS(int[] incEdge, List<List<Integer>> graph) {
        int[] order = new int[incEdge.length];
        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < incEdge.length; i++) {
            if (incEdge[i] == 0) {
                toVisit.add(i);
            }
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited] = from;
            visited++;
            for (int to : graph.get(from)) {
                incEdge[to]--;
                if (incEdge[to] == 0) {
                    toVisit.add(to);
                }
            }
        }
        if (visited == incEdge.length) {
            return order;
        } else {
            return new int[0];
        }
    }
}
