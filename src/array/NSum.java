package array;

import java.util.*;

/**
 * @author Xie Zexian
 * @description nSum问题
 * @createTime 2023/3/8 18:50
 */
public class NSum {
    public static void main(String[] args) {
        int[] sums = new int[]{-1, 0, 1, 2, -1, -4};
        int target = 0;
        System.out.println(threeSum(sums, target));
    }

    /**
     * @return 返回索引
     * @description 1.两数之和 (哈希表)
     * @createTime 2023/3/8 20:15
     */
    public static int[] twoSum(int[] nums, int target) {
        // HashMap!!!
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * @return 返回 所有 和为<target>的元素对，不能重复
     * param: nums 中的元素可以重复
     * @description 两数之和 (排序+双指针)
     * @createTime 2023/3/8 20:23
     */
    public static List<List<Integer>> twoSumTarget(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        // 双指针
        int low = 0, high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high) {
            int left = nums[low], right = nums[high];
            int sum = left + right;
            if (sum == target) {
                res.add(Arrays.asList(left, right));
                // 跳过所有重复元素
                while (low < high && nums[low] == left) {
                    low++;
                }
                while (low < high && nums[high] == right) {
                    high--;
                }
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }

    /**
     * @description 15.三数之和 (排序+双指针)
     * @createTime 2023/3/8 21:04
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 枚举a
        for (int i = 0; i < n; i++) {
            // 需要和上一次枚举的数不同，避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 左右指针
            int j = i + 1, k = n - 1;
            while (j < k) {
                // 需要和上一次枚举的数不同，避免重复
                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j >= k) {
                    break;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

}
