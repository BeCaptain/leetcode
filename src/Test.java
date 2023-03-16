import tree.BinaryTreeUtils;
import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 测试类
 * @createTime 2023/2/22 21:37
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.buildBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6});
        levelTraverse(root);
    }

    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                // 二叉树
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                // 多叉树
                // for (TreeNode child : cur.children) {
                //     queue.offer(child);
                // }
            }
            depth++;
        }

    }
}
