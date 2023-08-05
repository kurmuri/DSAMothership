package org.shandilya;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        int n = 4, k = 2;
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }
        //combine(n, k);
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}