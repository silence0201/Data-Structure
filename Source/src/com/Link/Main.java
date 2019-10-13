package com.Link;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new SingleLinkList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);

        System.out.println(list1);

        list1.remove(1);
        System.out.println(list1);

    }
}
