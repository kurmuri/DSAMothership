package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static void findCombination(int index, int[] arr, int target, List<Integer> combinationSoFar, List<List<Integer>> res) {
        if (index == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(combinationSoFar));
            }
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(combinationSoFar));
            return;
        }

        if (arr[index] <= target) {
            combinationSoFar.add(arr[index]);
            findCombination(index, arr, target-arr[index], combinationSoFar, res);
            combinationSoFar.remove(combinationSoFar.size()-1);
        }
        findCombination(index+1, arr, target, combinationSoFar, res);
    }

    // Given an array of distinct numbers in array arr and target value target
    // Return a list of all unique combinations of numbers where the chosen numbers sum to target
    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2,3,6,7};
        List<List<Integer>> res = new ArrayList<>();
        findCombination(0, arr, 7, new ArrayList<>(), res);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
