package com.Heap;

/**
 * Project Name:Data-Structure
 * Package Name:com.Link
 * File Name: Heap.java
 * Date:2019/11/16 上午11:41
 * Copyright © 2019 silence. All Rights Reserved.
 */

public interface Heap<E> {
    int size();	// 元素的数量
    boolean isEmpty();	// 是否为空
    void clear();	// 清空
    void add(E element);	 // 添加元素
    E get();	// 获得堆顶元素
    E remove(); // 删除堆顶元素
    E replace(E element); // 删除堆顶元素的同时插入一个新元素
}
