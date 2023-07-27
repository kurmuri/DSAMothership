package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private static void solve(int[] arr, List<Integer> hold, List<List<Integer>> res, boolean[] present) {
        if (hold.size() == arr.length) {
            res.add(new ArrayList<>(hold));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!present[i]) {
                present[i] = true;
                hold.add(arr[i]);
                solve(arr, hold, res, present);
                hold.remove(hold.size()-1);
                present[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        boolean[] present = new boolean[arr.length];
        List<Integer> hold = new ArrayList<>();
        solve(arr, hold,res,present);
        res.forEach(System.out::println);
    }
}
