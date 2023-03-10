package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 排列
 * @createTime 2023/2/27 19:55
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public static List<List<Integer>> res = new LinkedList<>();

    /**
     * @description 46.输入一组不重复的数组，返回它们的全排列
     * @createTime 2023/2/27 20:09
     */
    public static List<List<Integer>> permute(int[] nums) {
        // 记录[路径]
        LinkedList<Integer> track = new LinkedList<>();
        // [路径]中的元素会被标记为true，避免重复使用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        /*
         * 1.路径: track
         * 2.选择列表: nums中不存在于track中的元素(used[]中为false的)
         * 3.结束条件: nums中的元素都在track中
         */
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

}
