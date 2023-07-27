package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
    private static void solve(int index, int[] num, List<List<Integer>> res) {
        if (index == num.length) {
            List<Integer> hold = new ArrayList<>();
            for (Integer it : num) {
                hold.add(it);
            }
            res.add(new ArrayList<>(hold));
            return;
        }

        for (int i = index; i < num.length; i++) {
            swap(i, index, num);
            solve(index+1, num, res);
            swap(i, index, num);
        }
    }

    private static void swap(int here, int there, int[] num) {
        int temp = num[here];
        num[here] = num[there];
        num[there] = temp;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        solve(0, num, res);
        res.forEach(System.out::println);
    }
}
