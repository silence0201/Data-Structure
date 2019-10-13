package com.Link;

/**
 * Created by silence on 2019/10/13.
 */
public class LinkedList<E> extends AbstractList<E>{


    private Node<E> first;
    private Node<E> last;

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
        rangeCheckForAdd(index);

        if (index == size) {
            last = new Node<E>(element,null,last);
            if (last == null) { // 链表第一个元素
                first = last;
            } else {
                last.prev.next = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;

            Node<E> node = new Node<>(element,next,prev);
            next.prev = node;
            if (prev != null) {
                prev.next = node;
            } else {  // index == 0
                first = node;
            }
        }

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        if (node.prev != null)  {
            node.prev.next = node.next;
        } else {
            first = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }

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

        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1;i > index; i-- ) {
                node = node.prev;
            }
            return node;
        }

    }



    static private class Node<E> {
        E elementE;

        Node<E> next;
        Node<E> prev;

        public Node(E elementE, Node<E> next, Node<E> prev) {
            this.elementE = elementE;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "elementE=" + elementE +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("被释放了" + this);
        }

    }

}
