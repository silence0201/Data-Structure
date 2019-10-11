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

        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person(12,"Hell"));
        list2.add(new Person(13,"Worl"));
        list2.add(new Person(14,"CCC"));

        System.out.println(list);
        System.out.println(list2);
    }
}
