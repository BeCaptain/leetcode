package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description The Longest Common Subsequence, LCS
 * @createTime 2023/3/26 19:57
 */
public class LCS {
    public static void main(String[] args) {

    }

    /**
     * @description 1143.最长公共子序列 -- 自顶向下(递归) + 备忘录
     * @createTime 2023/3/26 20:04
     */
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp1143(s1, 0, s2, 0);
    }

    private static int[][] memo;

    public static int dp1143(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp1143(s1, i + 1, s2, j + 1) + 1;
        } else {
            memo[i][j] = Math.max(
                    dp1143(s1, i + 1, s2, j),
                    dp1143(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }

    /**
     * @description 1143.最长公共子序列 -- 自底向上 + DP Table
     * @createTime 2023/3/26 20:09
     */
    public static int longestCommonSubsequence2(String s1, String s2) {
        int m = s1.length();
        int n = s1.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
