package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsequences {

    private static void subSeq(int index, List<Integer> res, List<Integer> nums) {
        if(index >= nums.size()) {
            System.out.print("Subset : ");
            res.forEach(System.out::print);
            System.out.println();
            return;
        }
        res.add(nums.get(index));
        subSeq(index+1, res, nums);
        res.remove(nums.get(index));
        subSeq(index+1, res, nums);
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 1));
        subSeq(0, new ArrayList<>(), nums);
    }
}