package com.Heap;

import java.util.Comparator;


/**
 * Project Name:Data-Structure
 * Package Name:com.Heap
 * File Name: BinaryHeap.java
 * Date:2019/11/16 上午11:52
 * Copyright © 2019 silence. All Rights Reserved.
 */

public class BinaryHeap<E> extends AbstractHeap<E> {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator, E[] elements) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
            size = elements.length;
            for (int i=0;i<elements.length;i++) {
                this.elements[i] = elements[i];
            }
        }
    }

    private void heapify() {
        // 自下而上的上滤
        /*
        for (int i = 1 ; i < size;i++) {
            shiftUp(i);
        }*/


        // 自下而上的下滤
        for (int i = (size >> 1) - 1;i >=0; i--) {
            shiftDown(i);
        }
    }


    public BinaryHeap(Comparator<E> comparator) {
        this(comparator,null);
    }

    public BinaryHeap() {
        this(null,null);
    }



    @Override
    public void clear() {
        for (int i = 0; i< size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        shiftUp(size -1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();

        E root = elements[0];
        int lastIndex = -- size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        shiftDown(0);
        return root;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;

        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            shiftDown(0);
        }
        return root;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size;i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void shiftUp(int index) {
        // 有父节点
        E e = elements[index];
        while (index > 0) {
            // 获取父节点
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(e,p) <= 0) break;

            // 将父元素存储在index
            elements[index] = p;

            // 重新赋值index
            index = pindex;
        }
        elements[index] = e;
    }

    private void shiftDown(int index) {
        E element = elements[index];
        // 第一个叶子节点的索引 为非叶子节点的数量
        int half = size >> 1;
        while (index > half) {
            // 默认为左子节点
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            // 右子节点
            int rightIndex = childIndex + 1;

            // 选出最大的子节点
            if (rightIndex > size && compare(elements[rightIndex],child) > 0) {
                childIndex = rightIndex;
                child = elements[rightIndex];
            }

            if (compare(element,child) >= 0) break;

            // 将子节点存放到index
            elements[index] = child;
            // 重新设置index
            index = childIndex;
        }

        elements[index] = element;
    }
}
