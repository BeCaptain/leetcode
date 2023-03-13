package tree;

/**
 * @author Xie Zexian
 * @description 计算二叉树的节点数
 * @createTime 2023/3/13 14:55
 */
public class NodeCount {
    public static void main(String[] args) {

    }

    /**
     * @description 计算一颗【普通二叉树】的节点数，时间复杂度 O(N)
     * @createTime 2023/3/13 14:57
     */
    public static int countBinaryTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countBinaryTreeNode(root.left) + countBinaryTreeNode(root.right);
    }

    /**
     * @description 计算一颗【满二叉树】的节点数，节点总数与树的高度呈指数关系
     * @createTime 2023/3/13 14:58
     */
    public static int countPerfectBinaryTreeNode(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return (int) Math.pow(2, height) - 1;
    }

    /**
     * @description 计算一颗【完全二叉树】的节点数，时间复杂度 O(logN * logN)
     * @createTime 2023/3/13 14:59
     */
    public static int countCompleteBinaryTreeNode(TreeNode root) {
        TreeNode left = root, right = root;
        // 沿最左侧和最右侧分别计算高度
        int leftHeight = 0, rightHeight = 0;
        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }
        // 如果左右侧高度相同，则为满二叉树
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        // 左右侧高度不同，则按普通二叉树的逻辑计算
        return 1 + countCompleteBinaryTreeNode(root.left) + countCompleteBinaryTreeNode(root.right);
    }

}
