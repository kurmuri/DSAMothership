package lcs;

public class LCSRecursion {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";

        System.out.println(lcs(a, b, a.length(), b.length()));
    }

    private static int lcs(String a, String b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (a.charAt(m-1) == b.charAt(n-1)) {
            return 1 + lcs(a, b, m-1, n-1);
        } else {
            return Math.max(lcs(a, b, m-1, n), lcs(a, b, m, n-1));
        }
    }
}
