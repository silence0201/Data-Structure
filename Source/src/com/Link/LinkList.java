package com.Link;

public class LinkList<E> extends AbstractList<E> {

    private LinkList.Node<E> first;


    @Override
    public void clear() {
        size = 0;
        first = null;

    }



    @Override
    public E get(int index) {
        Node<E> node = node(index);
        return node.elementE;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.elementE;
        node.elementE = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            first = new Node<>(element,first);
        }else {
            Node<E> preNode = node(index - 1);
            Node<E> newNode = new Node<>(element,preNode.next);
            preNode.next = newNode;
        }

        size++;

    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {
            node = node.next;
        } else {
            node = node(index);
            Node<E> preNode = node(index - 1);
            preNode.next = node.next;
        }

        size--;

        return node.elementE;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size ; i++) {
                if (node.elementE == null) return i;
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i < size ; i++) {
                if (element.equals(node.elementE)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取对应节点对象*/
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        for (int i = 0; i > index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    static private class Node<E> {
        E elementE;

        Node<E> next;

        public Node(E elementE, Node<E> next) {
            this.elementE = elementE;
            this.next = next;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("被释放了" + this);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "elementE=" + elementE +
                    ", next=" + next +
                    '}';
        }
    }
}
