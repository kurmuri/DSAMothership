package org.shandilya.dp.boundedKnapsack;

import java.util.Arrays;

public class BinaryKS {
    public static void main(String[] args) {
        int capacity = 50;
        int[] weight = {10, 20, 30};
        int[] profit = {60, 100, 120};

        System.out.println("Max profit " + recursiveKS(weight, profit, capacity, 2));
        int[][] dp = new int[weight.length+1][capacity+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        System.out.println("Max profit using memoization " + memKS(weight, profit, capacity, 2, dp)) ;
        int[][] dpp = new int[weight.length+1][capacity+1];
        System.out.println(tabulationKS(weight, profit, capacity, dpp));
    }

    private static int tabulationKS(int[] wt, int[] pr, int cp, int[][] dp) {
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= cp; j++) {
                if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(pr[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[pr.length][cp];
    }

    private static int memKS(int[] wt, int[] pr, int cp, int id, int[][] dp) {
        if (cp == 0 || id == 0)
            return 0;
        if (dp[id][cp] != -1) {
            return dp[id][cp];
        }

        if (cp >= wt[id]) {
            return dp[id][cp] = Math.max(pr[id] + memKS(wt, pr, cp-wt[id], id-1, dp), memKS(wt, pr, cp, id-1, dp));
        } else {
            return dp[id][cp] = memKS(wt, pr, cp, id-1, dp);
        }
    }

    private static int recursiveKS(int[] weight, int[] profit, int capacity, int index) {
        if (capacity == 0 || index == 0)
            return 0;

        if (capacity >= weight[index]) {
            // Take or not take
            return Math.max(profit[index] + recursiveKS(weight, profit, capacity - weight[index], index-1),
                    recursiveKS(weight, profit, capacity, index-1));
        } else {
            // No Take
            return recursiveKS(weight, profit, capacity, index-1);
        }
    }


}
