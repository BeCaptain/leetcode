package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/2/25 22:05
 */
public class BinaryTreeUtils {

    /**
     * @return nums中的-1表示null
     * @description 给定一个数组，创建一个完全二叉树
     * @createTime 2023/2/25 22:33
     */
    public static TreeNode buildBinaryTree(int[] nums) {
        // 树节点列表
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (int num : nums) {
            treeNodeList.add(new TreeNode(num, null, null));
        }
        if (!treeNodeList.isEmpty()) {
            for (int j = 0; j < nums.length / 2; j++) {
                TreeNode treeNode = treeNodeList.get(j);
                // 因为索引从0开始，所以节点的左右孩子索引分别为(2 * i + 1)和(2 * i + 2)
                // 数组中 -1 表示 null
                if (2 * j + 1 < treeNodeList.size() && treeNodeList.get(2 * j + 1).val != -1) {
                    TreeNode leftChild = treeNodeList.get(2 * j + 1);
                    treeNode.setLeftChild(leftChild);
                }
                if (2 * j + 2 < treeNodeList.size() && treeNodeList.get(2 * j + 2).val != -1) {
                    TreeNode rightChild = treeNodeList.get(2 * j + 2);
                    treeNode.setRightChild(rightChild);
                }
            }
            // 返回根节点
            return treeNodeList.get(0);
        } else {
            return null;
        }
    }

    /**
     * @description 打印前序遍历
     * @createTime 2023/3/7 22:53
     */
    public static void printPreTraverse(TreeNode root) {
        preTraverse(root);
        System.out.println(preList);
    }

    public static List<String> preList = new ArrayList<>();

    /**
     * @description 前序遍历
     * @createTime 2023/2/25 22:44
     */
    public static void preTraverse(TreeNode root) {
        if (root == null) {
            preList.add("null");
            return;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            preList.add(root.val + "");
            return;
        }
        preList.add(root.val + "");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * @description 打印层次遍历的结果
     * @createTime 2023/3/8 11:12
     */

    public static void printLevelTraverse(TreeNode root) {
        levelTraverse(root);
        System.out.println(levelList);
    }

    public static List<String> levelList = new ArrayList<>();

    /**
     * @description 层次遍历
     * @createTime 2023/3/8 10:55
     */
    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    levelList.add("null");
                } else {
                    levelList.add(cur.val + "");
                    // 非叶子节点
                    if (cur.left != null || cur.right != null) {
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    }
                }
            }
        }
    }
}
