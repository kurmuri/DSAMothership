package org.shandilya.recursion;

public class Print1toN {

    private static void print(int n, int count) {
        if(count <= n) {
            System.out.println(count);
        } else {
            return;
        }

        print(n, ++count);
    }

    public static void main(String[] args) {
        print(5, 1);
    }
}