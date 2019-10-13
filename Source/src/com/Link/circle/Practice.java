package com.Link.circle;

/**
 * Created by silence on 2019/10/13.
 */
public class Practice {



    public static void main(String[] args) {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1 ; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }

    }
}
