package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

// Given an integer array which may contains duplicates, return all possible subsets, the power set. The solution set
// must not contain duplicates
public class Subsets2 {

    private static void fun(int index, int[] arr, List<Integer> soFar, List<List<Integer>> res) {
        res.add(new ArrayList<>(soFar));

        for (int i = index; i < arr.length; i++) {
            if (index != i && arr[i] == arr[i-1]) continue;
            soFar.add(arr[i]);
            fun(i+1, arr, soFar, res);
            soFar.remove(soFar.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        fun(0, arr, new ArrayList<>(), res);
        for (List<Integer> re : res) {
            System.out.print("Subset is : ");
            System.out.println(re);
        }
    }
}