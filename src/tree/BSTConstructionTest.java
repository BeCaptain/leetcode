package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 二叉搜索树-构造篇
 * @createTime 2023/3/12 21:42
 */
public class BSTConstructionTest {
    public static void main(String[] args) {

    }

    /**
     * @description 96.不同的二叉搜索树
     * @createTime 2023/3/12 21:44
     */
    public static int numTrees(int n) {
        memo96 = new int[n + 1][n + 1];
        return countBSTNum96(1, n);
    }

    /**
     * @description 备忘录 --> 重叠子问题
     */
    private static int[][] memo96;

    private static int countBSTNum96(int low, int high) {
        // base case
        if (low > high) {
            return 1;
        }
        // 查备忘录
        if (memo96[low][high] != 0) {
            return memo96[low][high];
        }
        int res = 0;
        for (int i = low; i < high; i++) {
            int left = countBSTNum96(low, i - 1);
            int right = countBSTNum96(i + 1, high);
            res += left * right;
        }
        // 将结果存入备忘录
        memo96[low][high] = res;
        return res;
    }

    /**
     * @description 95.不同的二叉搜索树II
     * @createTime 2023/3/13 10:02
     */
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateBST95(1, n);
    }

    private static List<TreeNode> generateBST95(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (low > high) {
            res.add(null);
            return res;
        }
        // 1.穷举root节点的所有可能性
        for (int i = low; i <= high; i++) {
            // 2.递归构造出左右子树的所有合法BST
            List<TreeNode> leftTree = generateBST95(low, i - 1);
            List<TreeNode> rightTree = generateBST95(i + 1, high);
            // 3.给root节点穷举所有左右子树的组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i作为根节点root的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
