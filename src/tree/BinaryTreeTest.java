package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 二叉树测试类
 * @createTime 2023/2/26 10:32
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
    }

    public static final String SEP = ",";
    public static final String NULL = "#";

    /**
     * @description 652.寻找重复的子树
     * @createTime 2023/3/9 21:13
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse652(root);
        return res;
    }

    // 记录所有子树以及出现的次数
    public static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    public static LinkedList<TreeNode> res = new LinkedList<>();

    public static String traverse652(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        String left = traverse652(root.left);
        String right = traverse652(root.right);
        // 后序位置

        // 序列化子树，用于判断是否重复
        String subTree = left + SEP + right + SEP + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 子树对应的出现次数+1
        memo.put(subTree, freq + 1);
        return subTree;
    }


    /**
     * @description 654.最大二叉树
     * @createTime 2023/3/8 10:28
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildMaxBinaryTree(nums, 0, nums.length - 1);
    }

    public static TreeNode buildMaxBinaryTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        // 找到数组中的最大值
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = buildMaxBinaryTree(nums, low, index - 1);
        root.right = buildMaxBinaryTree(nums, index + 1, high);
        return root;
    }


    /**
     * @description 226.翻转二叉树
     * @createTime 2023/3/7 20:44
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序位置
        invertTree(root.left);
        invertTree(root.right);
        // 后序位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    /**
     * @description 543.二叉树的直径
     * @createTime 2023/2/26 11:33
     */
    public static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        getMaxDiameter(root);
        return maxDiameter;
    }

    public static int getMaxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = getMaxDiameter(root.left);
        int rightMaxDepth = getMaxDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, leftMaxDepth + rightMaxDepth);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    /**
     * @description 104.二叉树的最大深度
     * @createTime 2023/2/26 11:33
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        // 加上根节点自己
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

}
