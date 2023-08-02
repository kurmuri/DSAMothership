package org.shandilya.dp.unboundedKnapsack;

public class UbKS {
    private static int funRec(int[] wt, int[] pr, int capacity, int index) {
        if (capacity == 0)
            return 0;
        if (index < 0)
            return 0;

        if (capacity >= wt[index]) {
            return Math.max(pr[index] + funRec(wt, pr, capacity-wt[index], index), funRec(wt, pr, capacity, index-1));
        } else {
            return funRec(wt, pr, capacity, index-1);
        }
    }

    private static int funTab(int[] wt, int[] pr, int capacity, int index, int[][] dp) {
        for (int i = 1; i < index+1; i++) {
            for (int j = 1; j < capacity+1; j++) {
                if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(pr[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[index][capacity];
    }

    public static void main(String[] args) {
        int[] pr = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int capacity = 8;

        System.out.println("Using recursion : "+ funRec(wt, pr, capacity, pr.length - 1));
        int[][] dp = new int[pr.length+1][capacity+1];
        System.out.println("Using DP : "+ funTab(wt, pr, capacity, pr.length, dp));
    }
}