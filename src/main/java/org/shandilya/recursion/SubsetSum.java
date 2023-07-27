package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void sum(int index, int sum, List<Integer> res, int[] arr) {
        if (index == arr.length) {
            res.add(sum);
            return;
        }
        sum(index+1, sum+arr[index], res, arr);
        sum(index+1, sum, res, arr);
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        int[] arr = {3, 1, 2};
        sum(0, 0, res, arr);
        Collections.sort(res);
        res.forEach(System.out::println);
    }
}