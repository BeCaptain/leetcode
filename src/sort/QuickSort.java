package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Xie Zexian
 * @description 快速排序, 时间复杂度: O(N * logN)
 * @createTime 2023/3/13 21:17
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 9, 1, 3, 6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        // 为避免极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组 (原地修改)
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 对nums[low, high]进行划分，使得nums[low, p-1] <= nums[p] < nums[p+1, high]
        int p = partition(nums, low, high);

        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    /**
     * @description 215.数组中的第K个最大元素 (随机选择算法，时间复杂度O(N))
     * @createTime 2023/3/14 10:53
     */
    public static int findKthLargest(int[] nums, int k) {
        // 首先随机打乱数组
        shuffle(nums);
        int low = 0, high = nums.length - 1;
        // 转化为【排名第K的元素】
        k = nums.length - k;
        while (low <= high) {
            // 在nums[low, high]中选择一个分界点
            int p = partition(nums, low, high);
            if (p < k) {
                // 第k大的元素在nums[p+1, high]中
                low = p + 1;
            } else if (p > k) {
                // 第k大的元素在nums[low, p-1]中
                high = p - 1;
            } else {
                // 找到第k大的元素
                return nums[p];
            }
        }
        return -1;
    }

    /**
     * @description 对nums[low, high]进行划分
     * @createTime 2023/3/13 21:56
     */
    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= pivot) {
                i++;
            }
            while (j > low && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    /**
     * @description 洗牌算法，将输入的数组随机打乱
     * @createTime 2023/3/13 21:53
     */
    private static void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    /**
     * @description 原地交换数组中的两个元素
     * @createTime 2023/3/13 21:53
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
