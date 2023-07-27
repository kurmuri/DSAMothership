package org.shandilya.recursion;

public class CheckPalindrome {
    private static boolean isPalindrome(String str, int index) {
        if (index >= str.length()/2) return true;
        return str.charAt(index) == str.charAt(str.length()-1-index) && isPalindrome(str, index+1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ara", 0));
        System.out.println(isPalindrome("arab", 0));
    }
}
