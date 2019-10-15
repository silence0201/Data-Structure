package com.Tree;

import com.Tree.printer.BinaryTrees;

import java.util.Comparator;

/**
 * Created by silence on 2019/10/15.
 */
public class Main {
    public static void main(String[] args) {

        Integer data[] = new Integer[] { 7,4,9,2,5,8,11,3,12,1 } ;

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer num : data) {
            bst.add(num);
        }

        BinaryTrees.println(bst);

        System.out.println("------------------------------------------------------------------------------");

        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        bst2.add(new Person(22,"Jekl"));
        bst2.add(new Person(33,"JKel"));
        bst2.add(new Person(42,"Jekl"));
        bst2.add(new Person(12,"Jekl"));
        bst2.add(new Person(15,"Jekl"));
        bst2.add(new Person(13,"JKel"));
        bst2.add(new Person(17,"JKel"));
        bst2.add(new Person(62,"Jekl"));
        bst2.add(new Person(73,"JKel"));
        bst2.add(new Person(53,"JKel"));


        BinaryTrees.println(bst2);


    }
}
