package com.Heap;

import com.Tree.Compare.Comparator;

/**
 * Project Name:Data-Structure
 * Package Name:com.Heap
 * File Name: AbstractHeap.java
 * Date:2019/11/16 下午1:01
 * Copyright © 2019 silence. All Rights Reserved.
 */

public abstract class AbstractHeap<E> implements Heap<E> {
    protected int size;
    protected Comparator<E> comparator;

    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public AbstractHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1,e2) : ((Comparable<E>)e1).compareTo(e2);
    }

    protected void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    protected void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

}
