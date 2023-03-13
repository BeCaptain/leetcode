package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/3/2 22:14
 */
public class Summary {
    public static void main(String[] args) {

    }

    // 1. 无重复不可复选
    // 1.1 组合(子集)

    private static List<List<Integer>> res = new ArrayList<>();

    private static LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subset_case1(int[] nums) {
        backtrack_subset_case1(nums, 0);
        return res;
    }

    public static void backtrack_subset_case1(int[] nums, int start) {
        // no base_case
        // 组合问题的话，在此处加限制条件，比如组合的值、几个树的组合
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 回溯
            backtrack_subset_case1(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    // 1.2 排列
    // 定义一个数组用于记录元素是否被用过
    public static boolean[] used;

    public List<List<Integer>> permute_case1(int[] nums) {
        used = new boolean[nums.length];
        backtrack_permute_case1(nums);
        return res;
    }

    public static void backtrack_permute_case1(int[] nums) {
        // base case: 到达底部
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            if (used[i]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            // 回溯递归
            backtrack_permute_case1(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }


    // 2. 有重复不可复选
    // 2.1 子集(组合)

    public List<List<Integer>> subset_case2(int[] nums) {
        // 排序：让相等的元素靠在一起
        Arrays.sort(nums);
        backtrack_subset_case2(nums, 0);
        return res;
    }

    public static void backtrack_subset_case2(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        // start: 控制元素的相对位置
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            // 递归回溯
            backtrack_subset_case2(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    // 2.2 排列

    public List<List<Integer>> permute_case2(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack_permute_case2(nums);
        return res;
    }

    public static void backtrack_permute_case2(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack_permute_case2(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    // 3. 无重复可复选
    // 3.1 子集(组合)


}
