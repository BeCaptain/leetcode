package dp;

/**
 * @author Xie Zexian
 * @description 接雨水
 * @createTime 2023/4/4 15:29
 */
public class Rainwater {
    public static void main(String[] args) {

    }

    /**
     * @description 42.接雨水 --- 暴力解法 O(N^2)
     * @createTime 2023/4/4 15:30
     */
    public static int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0, rightMax = 0;
            // 找右边最高的柱子
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    /**
     * @description 42.接雨水 --- 备忘录优化 O(N)
     * @createTime 2023/4/4 15:36
     */
    public static int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // 初始化
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        // 从左向右计算
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // 从右向左计算
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /**
     * @description 42.接雨水 --- 双指针
     * @createTime 2023/4/4 15:36
     */
    public static int trap3(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(right, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * @description 11.盛最多水的容器
     * @createTime 2023/4/4 15:56
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right]之间的矩形面积
            int curArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curArea);
            // 双指针，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
