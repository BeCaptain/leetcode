package dp;

/**
 * @author Xie Zexian
 * @description 股票买卖
 * @createTime 2023/4/2 19:46
 */
public class StockJobbing {
    public static void main(String[] args) {
        System.out.println(maxProfit309(new int[]{1}));
    }

    /**
     * @description 309.最佳买卖股票时机含 冷冻期
     * @createTime 2023/7/31 21:33
     */
    public static int maxProfit309(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        if (n >= 2) {
            dp[2][0] = Math.max(dp[1][0], dp[1][1] + prices[0]);
            dp[2][1] = Math.max(dp[1][1], dp[0][0] - prices[0]);
        }

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }


    /**
     * @description 122.买卖股票的最佳时机, k = infinity
     * @createTime 2023/4/2 19:47
     */
    public static int maxProfit122(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * @description 121.买卖股票的最佳时机, k = 1
     * @createTime 2023/4/2 19:48
     */
    public static int maxProfit121(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

}
