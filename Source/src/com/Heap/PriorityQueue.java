package com.Heap;

import java.util.Comparator;

/**
 * Project Name:Data-Structure
 * Package Name:com.Heap
 * File Name: PriorityQueue.java
 * Date:2019/11/16 下午4:46
 * Copyright © 2019 silence. All Rights Reserved.
 */

public class PriorityQueue<E> {
    private BinaryHeap<E> heap;

    public PriorityQueue(Comparator<E> comparator) {
        heap = new BinaryHeap<E>(comparator);
    }

    public PriorityQueue() {
        this(null);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    public void enQueue(E element) {
        heap.add(element);
    }

    public E deQueue() {
        return heap.remove();
    }

    public E front() {
        return heap.get();
    }
}
