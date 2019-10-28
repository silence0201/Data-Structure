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

    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = parent.left;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = parent.right;
        parent.right = grand;
        afterRotate(grand,parent,child);
    }

    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // 让parent成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;

        // 更新高度
        updateHeight(grand);
        updateHeight(parent);
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