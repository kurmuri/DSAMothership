package lcs;

public class LCSDp {
    public static void main(String[] args) {
        String a = "ab";
        String b = "ab";

        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = 0;
        }
        System.out.println(lcs(a, b, dp, a.length(), b.length()));
    }

    private static int lcs(String a, String b, int[][]dp, int m, int n) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
