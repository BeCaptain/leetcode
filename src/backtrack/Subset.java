package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/2/28 11:47
 */
public class Subset {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> res = new LinkedList<>();

    /**
     * @description 记录回溯算法的递归路径
     */
    public static LinkedList<Integer> track = new LinkedList<>();

    /**
     * @description 元素 1)不重复 2)不复选
     */
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack_78(nums, 0);
        return res;
    }

    public static void backtrack_78(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 控制树枝的遍历，避免产生重复的子集
            backtrack_78(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    /**
     * @description 元素 1)可重复 2)不复选
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack_90(nums, 0);
        return res;
    }

    public static void backtrack_90(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 跳过nums[i] == nums[i-1] -> 剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack_90(nums, i + 1);
            track.removeLast();
        }

    }
}
