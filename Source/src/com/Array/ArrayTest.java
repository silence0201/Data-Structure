package com.Array;

public class ArrayTest {
    public static void main(String[] args) {
        int array[] = new int[] {11,22,33};
        System.out.println(array);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(77);
        list.add(66);
        list.add(88);
        list.add(11);
        list.add(123);
        list.add(12345);
        list.add(88);
        list.add(11);
        list.add(123);
        list.add(12345);

        list.remove(0);


        System.out.println(list);
    }
}
