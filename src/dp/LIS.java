package dp;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 最长递增子序列 (The Longest Increasing Subsequence, LIS)
 * @createTime 2023/3/23 14:24
 */
public class LIS {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4, 2, 3};
        System.out.println(lengthOfLIS2(nums));
    }

    /**
     * @description 300.最长递增子序列 --> O(N^2)
     * @createTime 2023/3/23 14:40
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dpTable = new int[nums.length];
        Arrays.fill(dpTable, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpTable[i] = Math.max(dpTable[i], dpTable[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dpTable.length; i++) {
            res = Math.max(res, dpTable[i]);
        }
        return res;
    }

    /**
     * @description 300.最长递增子序列(patience sorting + binary search) --> O(NlogN) !!!
     * @createTime 2023/3/23 15:08
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            // 搜索左侧边界的二分查找
            int left = 0, right = piles - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= poker) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 没有找到合适的牌堆，新建一个堆
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        // 牌堆数就是LIS的长度
        return piles;
    }

}
