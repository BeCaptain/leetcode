package dp;

/**
 * @author Xie Zexian
 * @description 股票买卖
 * @createTime 2023/4/2 19:46
 */
public class StockJobbing {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    /**
     * @description 121.买卖股票的最佳时机
     * @createTime 2023/4/2 19:48
     */
    public static int maxProfit(int[] prices) {
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
