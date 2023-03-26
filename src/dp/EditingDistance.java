package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 编辑距离
 * @createTime 2023/3/26 16:36
 */
public class EditingDistance {
    public static void main(String[] args) {
        String word1 = "rad";
        String word2 = "apple";
        System.out.println(minDistance(word1, word2));
    }

    /**
     * @description 72.编辑距离 -- 自顶向下(递归) + 备忘录
     * @createTime 2023/3/26 16:36
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 备忘录初始化为特殊值
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp72(word1, m - 1, word2, n - 1);
    }

    private static int[][] memo;

    private static int dp72(String s1, int i, String s2, int j) {
        // base case
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            // 跳过
            memo[i][j] = dp72(s1, i - 1, s2, j - 1);
        } else {
            memo[i][j] = min(
                    // 插入
                    dp72(s1, i, s2, j - 1) + 1,
                    // 删除
                    dp72(s1, i - 1, s2, j) + 1,
                    // 替换
                    dp72(s1, i - 1, s2, j - 1) + 1
            );
        }
        return memo[i][j];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    /**
     * @description 72.编辑距离 -- 自底向上 + DP Table
     * @createTime 2023/3/26 17:03
     */
    public static int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i+1][j+1] --> s1[0..i]和s2[0..j]的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1],
                            dp[i - 1][j],
                            dp[i - 1][j - 1]
                    );
                }
            }
        }
        return dp[m][n];
    }

}
