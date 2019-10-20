package com.Tree;


import com.Tree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by silence on 2019/10/15.
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {

    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<E>(element,null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0 ;
        while (node != null) {
            cmp = compart(element,node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {

            }
        }

        // 看看插入到父节点的位置
        Node<E> newNode = new Node<>(element,parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;

    }


    // 前序遍历
    public void preorderTraversal() {
        preoederTraversal(root);
    }

    private void preoederTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preoederTraversal(node.left);
        preoederTraversal(node.right);
    }

    // 中序遍历
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    // 后序遍历
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    public void postorderTraversal(Node<E> node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    // 层序遍历
    public void levelOrderTranversal() {
        if (root == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public void levelOrderTranversal(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            if(visitor.visit(node.element)) return;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }



    public static interface Visitor<E> {

        boolean visit(E element);
    }


    public void remove(E element) {

    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {

        if (node.left == null || node.right == null) return 0;

        return 1 + Math.max(height(node.left),height(node.right));
    }

    public int height2() {
        if (root == null) return 0;
        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            // 即将访问下一层
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }

    public boolean isComplete() {
        if (root == null) return false;


        Queue<Node<E>> queue = new LinkedList<>();

        queue.offer(root);


        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }

            /*
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {  // 不符合定义
                return false;
            } else {  // 后面遍历的节点都必须是叶子节点
                leaf = true;
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }*/
        }
        return true;
    }

    // 前驱节点
    private Node<E> predecessor(Node<E> node) {
        if (node == null) return null;

        // 从左边找,然后一直找右(left.right.right.....)
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点.祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        return node.parent;
    }

    // 后继节点
    private Node<E> successor(Node<E> node) {
        if (node == null) return null;

        // 从左边找,然后一直找右(right.left.left.....)
        Node<E> p = node.right;
        if (node.left != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点.祖父节点中寻找后节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    public boolean contains(E element) {
        return false;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    private int compart(E e1, E e2) {
        if (comparator != null) {
            return  comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

    }
}
