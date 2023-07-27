package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    private static void fun(int index, int[] arr, int target, List<Integer> soFar, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(soFar));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i-1] == arr[i])
                continue;
            if (arr[i] > target)
                break;
            soFar.add(arr[i]);
            fun(i+1, arr, target-arr[i], soFar, res);
            soFar.remove(soFar.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2};
        int target = 4;
        List<List<Integer>> res = new ArrayList<>();
        fun(0, arr, target, new ArrayList<>(), res);
        for (List<Integer> re : res)
            System.out.println(re);
    }
}
