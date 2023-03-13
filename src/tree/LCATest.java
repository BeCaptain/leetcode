package tree;

import java.util.HashSet;

/**
 * @author Xie Zexian
 * @description 最近公共祖先 (The Lowest Common Ancestor, LCA)
 * @createTime 2023/3/13 11:33
 */
public class LCATest {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        int p = 5, q = 1;
        TreeNode node1 = new TreeNode(p);
        TreeNode node2 = new TreeNode(q);
        TreeNode root = BinaryTreeUtils.buildBinaryTree(nums);
        System.out.println(lowestCommonAncestor(root, node1, node2).val);
    }

    /**
     * @param root, p, q (p和q一定存在于树中!!!)
     * @description 236.二叉树的最近公共祖先
     * @createTime 2023/3/13 11:36
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find236(root, p, q);
    }

    public static TreeNode find236(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 前序位置
        if (root.val.equals(p.val) || root.val.equals(q.val)) {
            // 遇到目标值，直接返回 (因为p和q一定存在于树中)
            return root;
        }
        TreeNode left = find236(root.left, p, q);
        TreeNode right = find236(root.right, p, q);
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是LCA
            return root;
        }
        return left != null ? left : right;
    }

    /**
     * @param root, nodes
     * @description 1676.求一堆节点的最近公共祖先 (这一堆节点一定存在于树中)
     * @createTime 2023/3/13 11:54
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find1676(root, values);
    }

    public static TreeNode find1676(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }
        if (values.contains(root.val)) {
            return root;
        }
        TreeNode left = find1676(root.left, values);
        TreeNode right = find1676(root.right, values);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }


    /**
     * @param root, p, q (p和q可能不存在于树中!!!)
     * @return tree.TreeNode
     * @description 1644.二叉树的最近公共祖先II
     * @createTime 2023/3/13 14:02
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find1644(root, p, q);
        if (!foundP || foundQ) {
            return null;
        }
        // p 和 q 都存在于二叉树中，才有公共祖先
        return res;
    }

    public static boolean foundP = false, foundQ = false;

    public static TreeNode find1644(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = find1644(root.left, p, q);
        TreeNode right = find1644(root.right, p, q);
        // 后序位置，判断当前节点是不是LCA节点
        if (left != null && right != null) {
            return root;
        }
        // 后序位置，判断当前节点是不是目标值
        if (root.val.equals(p.val) || root.val.equals(q.val)) {
            // 找到了，记录一下
            if (root.val.equals(p.val)) {
                foundP = true;
            }
            if (root.val.equals(q.val)) {
                foundQ = true;
            }
            return root;
        }
        return left != null ? left : right;
    }

    /**
     * @description 235.二叉搜索树的最近公共祖先
     * @createTime 2023/3/13 14:15
     */
    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 < val2
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return findLCAFromBST(root, val1, val2);
    }

    public static TreeNode findLCAFromBST(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        // 当前节点太大，去左子树找
        if (root.val > val2) {
            return findLCAFromBST(root.left, val1, val2);
        }
        // 当前节点太小，去右子树找
        if (root.val < val1) {
            return findLCAFromBST(root.right, val1, val2);
        }
        // val1 <= root.val <= val2，当前节点就是LCA节点
        return root;
    }
}
