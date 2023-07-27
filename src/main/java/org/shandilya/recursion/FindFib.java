package org.shandilya.recursion;

public class FindFib {
    private static int fib(int n) {
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            System.out.print(fib(i) + ", ");
        }
        // 1 1 2 3 5 8 13
    }
}