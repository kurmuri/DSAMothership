package org.shandilya.recursion;

public class PrintNto1 {
    private static void print(int count) {
        if(count > 0) {
            System.out.println(count);
        } else {
            return;
        }
        print(--count);
    }

    public static void main(String[] args) {
        print(5);
    }
}
