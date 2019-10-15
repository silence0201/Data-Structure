package com.Tree;

import java.util.Comparator;

/**
 * Created by silence on 2019/10/15.
 */
public class Main {
    public static void main(String[] args) {

        Integer data[] = new Integer[] { 7,4,9,2,5,8,11,3 } ;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer num : data) {
            bst.add(num);
        }

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });


    }
}
