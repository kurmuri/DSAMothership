package org.shandilya.recursion;

public class SumOfNNumbers {
    // Parametrised
    private static void sum(int currentNumber, int sum) {
        if(currentNumber < 1) {
            System.out.println("Sum : " + sum);
            return;
        }
        sum(currentNumber-1, sum+currentNumber);
    }

    // Function return value way (AKA Functional recursion)
    private static int sum(int num) {
        if (num == 0) return 0;
        return num + sum(num-1);
    }

    public static void main(String[] args) {
        sum(4, 0);
        System.out.println(sum(4));
    }
}
