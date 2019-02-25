package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341_FlattenNestedListIterator {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list;
        private int listSize;

        private int idx = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            flatten(nestedList);
        }

        private void flatten(List<NestedInteger> nestedList) {
            if (nestedList != null) {
                for (NestedInteger nestedInteger : nestedList) {
                    if (nestedInteger.isInteger()) {
                        list.add(nestedInteger.getInteger());
                        listSize++;
                    } else {
                        flatten(nestedInteger.getList());
                    }
                }
            }
        }

        @Override
        public Integer next() {
            int res = list.get(idx);
            idx++;
            return res;
        }

        @Override
        public boolean hasNext() {
            if (idx < listSize)
                return true;

            return false;
        }
    }
}
