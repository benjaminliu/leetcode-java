package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/9/29.
 */
public class _133_CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (null == node) return null;
        Set<UndirectedGraphNode> set = new HashSet<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode temp;
        List<UndirectedGraphNode> ns = new ArrayList<>();
        List<UndirectedGraphNode> ns1 = new ArrayList<>();
        set.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        while (!queue.isEmpty()) {
            temp = queue.poll();

            UndirectedGraphNode n = new UndirectedGraphNode(temp.label);
            ns.add(n);
            ns1.add(temp);
            map.put(temp, n);

            for (UndirectedGraphNode t : temp.neighbors) {
                if (set.add(t)) {
                    queue.add(t);
                }
            }
        }
        List<UndirectedGraphNode> tns;
        for (int i = 0; i < ns.size(); i++) {

            for (UndirectedGraphNode tn : ns1.get(i).neighbors) {
                ns.get(i).neighbors.add(map.get(tn));
            }
        }
        return ns.get(0);
    }

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        return DFS(node);
    }

    public UndirectedGraphNode DFS(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) return map.get(node.label);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(DFS(neighbor));
        }

        return clone;
    }
}
