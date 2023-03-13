package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 组合
 * @createTime 2023/2/28 15:34
 */
public class Combine {
    public static void main(String[] args) {
        combine(4, 2);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> res = new LinkedList<>();

    private static LinkedList<Integer> track = new LinkedList<>();

    /**
     * @description 77.组合, 返回[1, n]中所有可能的k个数的组合
     * @createTime 2023/2/28 15:36
     */
    public static List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public static void backtrack(int n, int k, int start) {
        // 结束条件
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            backtrack(n, k, i + 1);
            // 撤销选择
            track.removeLast();
        }

    }

}
