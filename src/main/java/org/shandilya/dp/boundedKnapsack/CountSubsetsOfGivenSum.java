package org.shandilya.dp.boundedKnapsack;

public class CountSubsetsOfGivenSum {
    private static int fun(int[] arr, int sum, int index) {
        if (sum == 0) {
            return 1;
        }

        if (sum > 0 && index < 0) {
            return 0;
        }

        if (sum >= arr[index]) {
            return fun(arr, sum - arr[index], index-1) + fun(arr, sum, index-1);
        } else {
            return fun(arr, sum, index-1);
        }
    }

    private static int funTab(int[] arr, int sum, int index, int[][] dp) {
        for (int i = 1; i < index+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        System.out.println("Using recursion " + fun(arr, 10, arr.length - 1));
        int[][] dp = new int[arr.length+1][11];
        for (int i = 1; i < 11; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < arr.length+1; i++) {
            dp[i][0] = 1;
        }
        System.out.println("Using tabulation " + funTab(arr, 10, arr.length, dp));
    }
}
