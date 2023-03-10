
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class tree.TreeNode {
 *     int val;
 *     tree.TreeNode left;
 *     tree.TreeNode right;
 *     tree.TreeNode() {}
 *     tree.TreeNode(int val) { this.val = val; }
 *     tree.TreeNode(int val, tree.TreeNode left, tree.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        // 加上根节点自己
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
