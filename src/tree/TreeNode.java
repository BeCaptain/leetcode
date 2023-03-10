package tree;

/**
 * @author Xie Zexian
 * @description Definition for a binary tree node.
 * @createTime 2023/2/25 22:03
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeftChild(TreeNode leftNode) {
        this.left = leftNode;
    }

    public void setRightChild(TreeNode rightNode) {
        this.right = rightNode;
    }
}
