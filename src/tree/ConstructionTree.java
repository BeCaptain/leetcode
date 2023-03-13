package tree;

import java.util.HashMap;

/**
 * @author Xie Zexian
 * @description 二叉树的构造
 * @createTime 2023/3/9 20:29
 */
public class ConstructionTree {
    public static void main(String[] args) {

    }

    /**
     * @description 105.从前序与中序遍历序列构造二叉树
     * @createTime 2023/3/8 14:40
     */
    public TreeNode constructFromPreIn(int[] preorder, int[] inorder) {
        return buildTreeFromPreIn105(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length);
    }

    private static TreeNode buildTreeFromPreIn105(int[] preorder, int preStart, int preEnd,
                                                  int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        // root节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal在中序遍历数组中的索引
        // 查到索引的for-loop可能效率低，可以换成HashMap(题目已说元素不唯一)
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 递归构建左右子树
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = buildTreeFromPreIn105(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = buildTreeFromPreIn105(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

    /**
     * @description 106.从中序和后序遍历结果构造二叉树
     * @createTime 2023/3/8 15:49
     */
    public static TreeNode constructFromInPost(int[] inorder, int[] postorder) {
        return buildTreeFromInPost106(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTreeFromInPost106(int[] inorder, int inStart, int inEnd,
                                                   int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }
        // root是后序遍历结果的最后一个元素
        int rootVal = postorder[postEnd];
        // 查找根节点在中序遍历结果的索引
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 递归构造左右子树
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = buildTreeFromInPost106(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = buildTreeFromInPost106(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    /**
     * @description 889.根据前序和后序遍历构造二叉树(结果可能不唯一)
     * @createTime 2023/3/8 16:31
     */
    private static HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return buildTreeFromPrePost889(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTreeFromPrePost889(int[] preorder, int preStart, int preEnd,
                                                    int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 多了一个 base case
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        // 根节点值及其索引
        int rootVal = preorder[preStart];
        // 左子树的根节点
        int leftRootVal = preorder[preStart + 1];
        int rootIndex = valToIndex.get(leftRootVal);
        // 左子树的元素个数
        int leftSize = rootIndex - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeFromPrePost889(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, rootIndex);
        root.right = buildTreeFromPrePost889(preorder, rootIndex + leftSize + 1, preEnd,
                postorder, rootIndex + 1, postEnd - 1);
        return root;
    }
}
