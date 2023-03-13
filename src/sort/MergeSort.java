package sort;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 归并排序, 时间复杂度: O(N * logN)
 * @createTime 2023/3/9 21:58
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 8, 4, 1, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * @description 用于辅助合并有序数组
     */
    private static int[] temp;

    public static void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low == high) {
            // 单个元素不用排序
            return;
        }
        // 防止溢出
        int mid = low + (high - low) / 2;
        // 对左半部分数组[low..mid]排序
        sort(nums, low, mid);
        // 对右半部分数组[mid+1..high]排序
        sort(nums, mid + 1, high);
        // 将两部分有序数组合并成一个有序数组
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        // 双指针
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[k] = temp[j++];
            } else if (j == high + 1) {
                // 右半边数据已全部被合并
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }
    }


}
