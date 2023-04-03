package other;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 同时查找缺失和重复的元素
 * @createTime 2023/4/3 21:24
 */
public class MissingDuplicatedNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 2};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    /**
     * @description 645.错误的集合, 找出重复和丢失的整数
     * @createTime 2023/4/3 21:26
     */
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 元素从1开始
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // 索引转换为元素
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }
}
