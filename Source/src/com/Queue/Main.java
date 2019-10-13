package com.Queue;

/**
 * Created by silence on 2019/10/13.
 */
public class     Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
