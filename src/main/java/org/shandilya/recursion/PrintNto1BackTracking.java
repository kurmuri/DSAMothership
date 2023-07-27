package org.shandilya.recursion;

public class PrintNto1BackTracking {
    private static void print(int count, int upto) {
        if (count > upto) return;
        print(count+1, upto);
        System.out.println(count);
    }

    public static void main(String[] args) {
        print(1, 5);
    }
}
