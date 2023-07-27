package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumSubSequence {
    private static void kSum(int sum, int index, List<Integer> res, List<Integer> nums) {
        if (index >= nums.size()) {
            int total = 0;
            for (Integer re : res) {
                total += re;
            }

            if (total == sum) {
                System.out.println("K Sum subsequence");
                res.forEach(System.out::print);
                System.out.println();
            }
            return;
        }

        res.add(nums.get(index));
        kSum(sum, index+1, res, nums);
        res.remove(nums.get(index));
        kSum(sum, index+1, res, nums);
    }

    private static void kSumAlternate(int sum, int index, List<Integer> res, List<Integer> nums) {
        if (index >= nums.size()) {
            if (sum == 0) {
                System.out.println("K Sum : ");
                res.forEach(System.out::print);
                System.out.println();
            }
            return;
        }

        res.add(nums.get(index));
        kSumAlternate(sum-nums.get(index), index+1, res, nums);
        res.remove(nums.get(index));
        kSumAlternate(sum, index+1, res, nums);
    }

    private static boolean printOneSS(int sum, int index, List<Integer> res, List<Integer> nums) {
        if (index >= nums.size()) {
            if (sum == 0) {
                System.out.println("K Sum : ");
                res.forEach(System.out::print);
                System.out.println();
                return true;
            }
            return false;
        }
        res.add(nums.get(index));
        if (printOneSS(sum-nums.get(index), index+1, res, nums)) {
            return true;
        }
        res.remove(nums.get(index));
        return printOneSS(sum, index + 1, res, nums);
    }

    public static void main(String[] args) {
        kSum(2, 0, new ArrayList<>(), new ArrayList<>(Arrays.asList(1,2,1)));
        kSumAlternate(2, 0, new ArrayList<>(), new ArrayList<>(Arrays.asList(1,2,1)));
        printOneSS(2, 0, new ArrayList<>(), new ArrayList<>(Arrays.asList(1,2,1)));
    }
}