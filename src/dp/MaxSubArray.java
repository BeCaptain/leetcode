package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 最大子数组
 * @createTime 2023/3/26 21:48
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayPreSum(nums));
    }

    /**
     * @description 53.最大子数组和 -- DP
     * @createTime 2023/3/26 21:55
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // dp[i]: 以nums[i]为结尾的最大子数组和 !!!
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    /**
     * @description 53.最大子数组和 -- 滑动窗口
     * @createTime 2023/3/26 21:59
     */
    public static int maxSubArraySlidingWindow(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while (right < nums.length) {
            // 扩大窗口
            windowSum += nums[right];
            right++;
            // 更新答案
            maxSum = Math.max(maxSum, windowSum);
            // 判断窗口是否要收缩
            while (windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }

    /**
     * @description 53.最大子数组和 -- 前缀和
     * @createTime 2023/3/26 22:13
     */
    public static int maxSubArrayPreSum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, preSum[i]);
            res = Math.max(res, preSum[i + 1] - minVal);
        }
        return res;
    }
}
