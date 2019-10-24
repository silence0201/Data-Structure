package com.CustomTree.AVLTree;

import com.CustomTree.tree.BST;

import java.util.Comparator;

/**
 * Project Name:Data-Structure
 * Package Name:com.CustomTree.AVLTree
 * File Name: AVLTree.java
 * Date:2019/10/22 下午11:26
 * Copyright © 2019 silence. All Rights Reserved.
 */

public class AVLTree<E> extends BST<E> {
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected Node<E> createNode(E elemetn, Node<E> parent) {
        return new AVLNode<>(elemetn,parent);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        super.afterAdd(node);

        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 更新高度
                updateHeight(node);
            } else {
                // 恢复平衡
                rebalance(node);
                break;
            }
        }

    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }


    private boolean isBalanced(Node<E> node) {
        int balance = ((AVLNode<E>)node).balanceFactor();

        return Math.abs(balance) <= 1;
    }

    /*恢复平衡*/
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();

        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL
                rotateRight(grand);
            } else { // LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else { // R
            if (node.isLeftChild()) { // RL
                rotateRight(parent);
                rotateLeft(grand);
            } else { // RR
                rotateLeft(grand);
            }
        }
    }

    private void rotateLeft(Node<E> node) {

    }

    private void rotateRight(Node<E> node) {

    }


    private static class AVLNode<E> extends Node<E> {

        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = left == null ? 0 : ((AVLNode<E>)right).height;

            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = left == null ? 0 : ((AVLNode<E>)right).height;

            height = 1 + Math.max(leftHeight,rightHeight);
        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = left == null ? 0 : ((AVLNode<E>)right).height;

            if (leftHeight > rightHeight) return left;
            if (rightHeight > leftHeight) return right;

            if (this.isLeftChild()) return left;

            return right;
        }

    }
}
