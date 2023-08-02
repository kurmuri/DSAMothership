package org.shandilya.dp.boundedKnapsack;

public class MinSubsetSumDiff {

    private static boolean hasSubsetSum(int[] arr, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        if (index < 0) {
            return false;
        }

        if (sum >= arr[index]) {
            return hasSubsetSum(arr, sum-arr[index], index-1) || hasSubsetSum(arr, sum, index-1);
        } else {
            return hasSubsetSum(arr, sum, index - 1);
        }
    }

    private static boolean ssTab(int[] arr, int sum, int index, boolean[][] dp) {
        for (int i = 1; i < index+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[index][sum];
    }

    public static void main(String[] args) {
        //int[] arr = {1,6,11,5}; // 1
        int[] arr = {1,2,7}; // 4

        // Say there are two subsets s1 and s2 in the given array
        // s1 + s2 = R, where R is the total sum of all the numbers, aka, Range
        // Imagine a number line 0 to R, S1 is some subset on left side, S2 is some subset on right side
        // Now imagine a line somewhere on the middle of the Range line, where left side s1 has right side s2
        // Essentially we need to find the closet number possible to the middle line from the left or right for which
        // there is a subset sum possible in the array. Find that number, find the other number, R - (the number found)
        // Take a difference, that's minimum subset sum difference which is possible on the given array

        int sum = 0;
        int range = 0;
        for (Integer it : arr) {
            range += it;
        }
        sum = range;
        range /= 2;
        while (range > 0) {
            if (hasSubsetSum(arr, range, arr.length-1))
                break;
            range--;
        }
        System.out.println();
        System.out.println("Minimum sum is " + ((sum - range) - range));
    }
}