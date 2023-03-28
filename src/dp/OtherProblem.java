package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description other problem of dp
 * @createTime 2023/3/23 19:08
 */
public class OtherProblem {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    /**
     * @description 931.下降路径最小和
     * @createTime 2023/3/23 19:09
     */
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        memo931 = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 备忘录里的值初始化为66666
            Arrays.fill(memo931[i], 66666);
        }

        // 终点可能在最后一行的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp931(matrix, n - 1, j));
        }
        return res;
    }

    /**
     * @description 备忘录
     */
    private static int[][] memo931;

    private static int dp931(int[][] matrix, int i, int j) {
        // 非法索引
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            // 返回一个特殊值
            return 99999;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }

        if (memo931[i][j] != 66666) {
            return memo931[i][j];
        }
        memo931[i][j] = matrix[i][j] + getMin(
                matrix[i - 1][j],
                matrix[i - 1][j - 1],
                matrix[i - 1][j + 1]);
        return memo931[i][j];
    }

    private static int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    /**
     * @description 115.不同的子序列
     * @createTime 2023/3/23 19:50
     */
    public static int numDistinct(String s, String t) {
        memo115 = new int[s.length()][t.length()];
        for (int[] row : memo115) {
            Arrays.fill(row, -1);
        }
        return dp315(s, 0, t, 0);
    }

    private static int[][] memo115;

    // s[i..]的子序列中t[j..]出现的次数为dp315(s, i, t, j)
    private static int dp315(String s, int i, String t, int j) {
        // base case 1: t全部匹配完成
        if (j == t.length()) {
            return 1;
        }
        // base case 2: s[i..]比t[j..]要短，必然没有匹配的子序列
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        // 备忘录
        if (memo115[i][j] != -1) {
            return memo115[i][j];
        }
        int res = 0;
        // view1: t角度穷举 -- 在s[i..]中寻找k，使得s[k] == t[j]
        // for (int k = i; k < s.length(); k++) {
        //     if (s.charAt(k) == t.charAt(j)) {
        //         res += dp315(s, k + 1, t, j + 1);
        //     }
        // }
        // view2: s角度穷举 --
        if (s.charAt(i) == t.charAt(j)) {
            // 匹配，两种情况累加关系
            res += dp315(s, i + 1, t, j + 1) + dp315(s, i + 1, t, j);
        } else {
            // 不匹配，在s[i+1...]的子序列中计算t[j..]出现的次数
            res += dp315(s, i + 1, t, j);
        }
        memo115[i][j] = res;
        return res;
    }

    /**
     * @description 64.最小路径和 -- 自顶向下(递归)
     * @createTime 2023/3/28 20:27
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo64 = new int[m][n];
        for (int[] row : memo64) {
            Arrays.fill(row, -1);
        }
        return dp64(grid, m - 1, n - 1);
    }

    private static int[][] memo64;

    private static int dp64(int[][] grid, int i, int j) {
        // base case (到达右下角)
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo64[i][j] != -1) {
            return memo64[i][j];
        }
        memo64[i][j] = Math.min(
                dp64(grid, i - 1, j),
                dp64(grid, i, j - 1)
        ) + grid[i][j];
        return memo64[i][j];
    }

    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpTable = new int[m][n];
        // base case
        dpTable[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dpTable[i][0] = dpTable[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dpTable[0][j] = dpTable[0][j - 1] + grid[0][j - 1];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpTable[i][j] = Math.min(dpTable[i - 1][j], dpTable[i][j - 1]) + grid[i][j];
            }
        }
        return dpTable[m - 1][n - 1];
    }
}
