package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * @description 315.计算右侧小于当前元素的个数
     * @createTime 2023/3/13 20:23
     */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp315 = new Pair[n];
        Pair[] arr = new Pair[n];
        // 记录元素原始的索引位置，以便在count数组中更新结果
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        // 归并排序，本题结果被记录在count数组中
        sort315(arr, 0, n - 1);

        List<Integer> res = new ArrayList<>();
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private static class Pair {
        int val;
        int id;

        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }

    // 归并排序所用的辅助数组
    private static Pair[] temp315;
    // 记录每个元素后面比自己小的元素个数
    private static int[] count;

    private static void sort315(Pair[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort315(arr, low, mid);
        sort315(arr, mid + 1, high);
        merge315(arr, low, mid, high);
    }

    private static void merge315(Pair[] arr, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp315[i] = arr[i];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                arr[k] = temp315[j++];
            } else if (j == high + 1) {
                arr[k] = temp315[i++];
                // 更新count数组
                count[arr[k].id] += j - mid - 1;
            } else if (temp315[i].val > temp315[j].val) {
                arr[k] = temp315[j++];
            } else {
                arr[k] = temp315[i++];
                // 更新count数组
                count[arr[k].id] += j - mid - 1;
            }
        }
    }
}
