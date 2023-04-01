package dp;

/**
 * @author Xie Zexian
 * @description 背包问题
 * @createTime 2023/4/1 11:23
 */
public class Knapsack {
    public static void main(String[] args) {
        int capacity = 6;
        int[] weight = new int[]{2, 3, 5};
        int[] value = new int[]{5, 2, 8};
        System.out.println(canPartition(weight));
    }

    /**
     * @description 0-1背包问题
     * @createTime 2023/4/1 11:32
     */
    public static int knapsack(int capacity, int[] weight, int[] value) {
        int n = weight.length;
        // dp[i][w]: 对于前i个物品，当前背包容量为w时，可以装下的最大价值
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (w - weight[i - 1] < 0) {
                    // 装不下
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            value[i - 1] + dp[i - 1][w - weight[i - 1]]
                    );
                }
            }
        }
        return dp[n][capacity];
    }

    /**
     * @description 416.分割等和子集 --- 背包问题的变体
     * @createTime 2023/4/1 13:25
     */
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和肯定是偶数
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            // 背包没空间相当于装满了
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= sum; w++) {
                if (w - nums[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = dp[i - 1][w] || dp[i - 1][w - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * @description 518.零钱兑换II --- 完全背包问题
     * @createTime 2023/4/1 21:49
     */
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

}
