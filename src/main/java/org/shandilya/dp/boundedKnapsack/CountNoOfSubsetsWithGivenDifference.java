package org.shandilya.dp.boundedKnapsack;

// This can also be reduced to target sum problem where we can apply + and - sign and target is
// to find a target value. We need to find the ways in which we can find the count
// https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
public class CountNoOfSubsetsWithGivenDifference {

    private static int countRec(int[] ar, int sum, int index) {
        if (sum == 0)
            return 1;
        if (index < 0)
            return 0;

        if (sum >= ar[index]) {
            return countRec(ar, sum-ar[index], index-1) + countRec(ar, sum, index-1);
        } else {
            return countRec(ar, sum, index-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3}; // 3
        int diff = 1;
        // s1 and s2 be two subsets
        // s1 - s2 = diff
        // s1 + s2 = sum
        // Adding the above two, 2s1 = (diff+sum), s1 = (diff+sum)/2
        // Find the occurrence s1 in the array
        int totalSum = 0;
        for (Integer it : arr) {
            totalSum += it;
        }

        int sum = (diff+totalSum)/2;
        System.out.println("Using recursion " + countRec(arr, sum, arr.length - 1));

    }
}