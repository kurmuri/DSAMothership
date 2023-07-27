package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static void solve(int index, List<List<String>> res, List<String> hold, String s) {
        if (index == s.length()) {
            res.add(new ArrayList<>(hold));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                hold.add(s.substring(index, i+1));
                solve(i+1, res, hold, s);
                hold.remove(hold.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> res = new ArrayList<>();
        List<String> hold = new ArrayList<>();
        solve(0, res, hold, s);
        res.forEach(System.out::println);
    }
}