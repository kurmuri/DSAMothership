package org.shandilya.recursion;

public class Print1toNBackTracking {
    private static void print(int count) {
        if (count < 1) {
            return;
        }
        print(count-1);
        System.out.println(count);
    }

    public static void main(String[] args) {
        print(5);
    }
}
