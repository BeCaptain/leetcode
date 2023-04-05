package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 单调栈
 * @createTime 2023/4/5 11:16
 */
public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] temperatures = new int[]{30, 40, 50, 60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    /**
     * @description 单调栈 -- 下一个更大的元素
     * @createTime 2023/4/5 11:24
     */
    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 矮个起开
                stack.pop();
            }
            // nums[i]身后更大的元素
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    /**
     * @description 496.下一个更大的元素I
     * @createTime 2023/4/5 11:25
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int[] res = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < m; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    /**
     * @description 739.每日温度
     * @createTime 2023/4/5 11:35
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 栈此时存放索引
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    /**
     * @description 503.下一个更大元素II -- 环形数组
     * @createTime 2023/4/5 15:03
     */
    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引 i 求模
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
