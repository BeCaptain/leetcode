package tree;

/**
 * @author Xie Zexian
 * @description 二叉搜索树-操作篇
 * @createTime 2023/3/11 10:44
 */
public class BSTOperationTest {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4, 2, 7, 1, 3};
        TreeNode root = BinaryTreeUtils.buildBinaryTree(nums);
        TreeNode res = searchBST(root, 2);
        System.out.println(res.val);
    }

    /**
     * @description 二叉搜索树中删除某个节点
     * @createTime 2023/3/12 21:40
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            // 找到节点，执行删除操作
            // case1: 末端节点，左右子树为空   --> 直接删除
            // case2: 只有一个非空子树        --> 让非空子树接替该节点位置
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // case3: 左右子树都不为空        --> 左子树的最大节点或右子树的最小节点接替该节点位置
            // 获取右子树中最小的节点
            TreeNode minNode = getMinOfRightSubTree(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换root
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            // 左子树找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static TreeNode getMinOfRightSubTree(TreeNode node) {
        // BST最左边的节点就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * @description 701.二叉搜索树中的插入操作
     * @createTime 2023/3/11 16:10
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    /**
     * @description 700.二叉树搜索树中的搜索
     * @createTime 2023/3/11 14:12
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     * @description 98.验证二叉搜索树
     * @createTime 2023/3/11 13:56
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合max和min的限制，说明BST不合法
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是root.val，右子树的最小值是root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    /**
     * @description 538.把二叉搜索树转换为累加树
     * @createTime 2023/3/11 10:45
     */
    public static TreeNode convertBST(TreeNode root) {
        traverse538(root);
        BinaryTreeUtils.printLevelTraverse(root);
        return null;
    }

    private static int sum = 0;

    private static void traverse538(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse538(root.right);
        root.val = root.val + sum;
        sum = root.val;
        traverse538(root.left);
    }
}
