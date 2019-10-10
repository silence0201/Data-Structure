package com.complexity;

import com.tools.Times;

public class Simple1 {

    // 0 1 1 2 3 5 8 13 ....

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(20));
        System.out.println(fib(40));
//        System.out.println(fib(64));

        System.out.println("--------------");

        System.out.println(fib2(0));
        System.out.println(fib2(20));
        System.out.println(fib2(40));
        System.out.println(fib2(64));

        System.out.println("--------------");

        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib(40));
            }
        });

        Times.test("fib2", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib2(40));
            }
        });
    }

    // O(2^n)
    static int fib(int n) {
        if ( n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // O(n)
    static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n -1; i++) {
            second = first + second;
            first = second - first;
        }

        return second;
    }
}
