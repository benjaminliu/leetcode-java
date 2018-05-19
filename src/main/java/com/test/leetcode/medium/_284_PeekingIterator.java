package com.test.leetcode.medium;

import java.util.Iterator;

/**
 * Created by ben on 2017/10/30.
 */
public class _284_PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextInt;

    public _284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (null == nextInt) {
            nextInt = iterator.next();
        }
        return nextInt;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ret;
        if (null != nextInt) {
            ret = nextInt;
            nextInt = null;
        } else {
            ret = iterator.next();
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (null != nextInt) return true;

        return iterator.hasNext();
    }
}
