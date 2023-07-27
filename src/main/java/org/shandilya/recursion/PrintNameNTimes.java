package org.shandilya.recursion;

public class PrintNameNTimes {

    private static void print(String name, int n, int count) {
        if(count < n) {
            System.out.println(name);
        } else {
            return;
        }
        print(name, n, count+1);
    }

    public static void main(String[] args) {
        print("Ramendu", 3, 0);
    }
}
