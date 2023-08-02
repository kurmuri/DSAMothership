package org.shandilya.dp.binaryKnapsack;

public class SubsetSum {
    public static void main(String[] args) {
        /*int[] wt = {2,3,7,8,10};
        System.out.println(hasSubsetSumRec(wt, 12, 4));
        System.out.println(hasSubsetSumRec(wt, 10, 4));
        System.out.println(hasSubsetSumRec(wt, 100, 4));

        int sum = 12;

        boolean[][] memDp = new boolean[6][sum+1];
        for (int i = 0; i < wt.length+1; i++) {
            memDp[i][0] = Boolean.TRUE;
        }

        for (int i = 1; i < sum; i++) {
            memDp[0][i] = Boolean.FALSE;
        }

        System.out.println("Using tabulation : " + hasSubsetTabulation(wt, memDp, sum, wt.length));*/

        int[] wt = {1,2,5};
        int sumOne = 4;

        boolean[][] memDpOne = new boolean[6][sumOne+1];
        for (int i = 0; i < wt.length+1; i++) {
            memDpOne[i][0] = Boolean.TRUE;
        }

        for (int i = 1; i < sumOne; i++) {
            memDpOne[0][i] = Boolean.FALSE;
        }

        System.out.println("Using tabulation : " + hasSubsetTabulation(wt, memDpOne, sumOne, wt.length));
    }

    private static boolean hasSubsetTabulation(int[] wt, boolean[][] dp, int sum, int index) {
        for (int i = 1; i < index + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= wt[i-1]) {
                    dp[i][j] = dp[i-1][j-wt[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[index][sum];
    }

    private static boolean hasSubsetSumRec(int[] wt, int sum, int index) {
        if (sum == 0)
            return true;
        if (index < 0)
            return false;

        if (sum >= wt[index]) {
            return hasSubsetSumRec(wt, sum - wt[index], index-1) || hasSubsetSumRec(wt, sum, index-1);
        } else {
            return hasSubsetSumRec(wt, sum, index-1);
        }
    }
}