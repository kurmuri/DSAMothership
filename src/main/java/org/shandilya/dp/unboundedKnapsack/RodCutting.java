package org.shandilya.dp.unboundedKnapsack;

public class RodCutting {
    private static int funRec(int[] pr, int maxLen, int index) {
        if (maxLen == 0)
            return 0;
        if (index < 0)
            return 0;
        if (index+1 <= maxLen) {
            return Math.max(pr[index] + funRec(pr, maxLen-index-1, index), funRec(pr, maxLen, index-1));
        } else {
            return funRec(pr, maxLen, index-1);
        }
    }
    public static void main(String[] args) {
        int[] pr = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max profit : " + funRec(pr, pr.length, pr.length - 1));
    }
}
