package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/2/27 14:06
 */
public class DpTest {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 6;
        System.out.println(coinChange(coins, amount));
    }

    private static int[] memo;

    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }

    public static int dp(int[] coins, int amount) {
        printIndent(n++);
        System.out.println("amount = " + amount);
        // base case
        if (amount == 0) {
            printIndent(n--);
            System.out.println("return 0");
            return 0;
        }
        if (amount < 0) {
            printIndent(n--);
            System.out.println("return -1");
            return -1;
        }
        // 查备忘录，避免重复计算
        if (memo[amount] != -666) {
            printIndent(n--);
            System.out.println("return " + memo[amount]);
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果

            int subproblem = dp(coins, amount - coin);
            // 如果子问题无解则跳过
            if (subproblem == -1) {
                continue;
            }
            // 在子问题中选择最优解
            res = Math.min(res, subproblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        printIndent(n--);
        System.out.println("return " + memo[amount]);
        return memo[amount];
    }

    private static int n = 0;

    /**
     * @description 打印缩进 (递归调试)
     * @createTime 2023/3/23 19:07
     */
    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }
}
