package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 二叉树序列号
 * @createTime 2023/3/8 21:28
 */
public class Serialize {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, -1, 4};
        TreeNode root = BinaryTreeUtils.buildBinaryTree(nums);
    }

    public static final String SEP = ",";
    public static final String NULL = "#";

    /**
     * @description 【前序】遍历
     * @createTime 2023/3/8 22:07
     */
    public static void preTraverse(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        preTraverse(root.left, sb);
        preTraverse(root.right, sb);
    }

    /**
     * @description 把一棵二叉树序列化成字符串 【前序】遍历
     * @createTime 2023/3/8 21:31
     */
    public static String serializePreTraverse(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preTraverse(root, sb);
        return sb.toString();
    }

    /**
     * @description 把字符串反序列化成二叉树 【前序】遍历
     * @createTime 2023/3/8 21:31
     */
    public static TreeNode deserializePreTraverse(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializePre(nodes);
    }

    /**
     * @description 反序列化递归函数 【前序】遍历
     * @createTime 2023/3/8 22:07
     */
    public static TreeNode deserializePre(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 第一个元素是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserializePre(nodes);
        root.right = deserializePre(nodes);
        return root;
    }

    /**
     * @description 【后序】遍历
     * @createTime 2023/3/8 22:12
     */
    public static void postTraverse(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append(NULL).append(SEP);
            return;
        }
        postTraverse(root.left, sb);
        postTraverse(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    /**
     * @description 把一棵二叉树序列化成字符串 【后序】遍历
     * @createTime 2023/3/8 22:09
     */
    public static String serializePostTraverse(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postTraverse(root, sb);
        return sb.toString();
    }


    /**
     * @description 把字符串反序列化成二叉树 【后序】遍历
     * @createTime 2023/3/8 22:15
     */
    public static TreeNode deserializePostTraverse(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SEP)) {
            nodes.addLast(node);
        }
        return deserializePost(nodes);
    }

    /**
     * @description 反序列化递归函数 【后序】遍历
     * @createTime 2023/3/8 22:16
     */
    public static TreeNode deserializePost(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 最后一个节点才是根节点
        String last = nodes.removeLast();
        if (last.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 先构造右子树，后构造左子树
        root.right = deserializePre(nodes);
        root.left = deserializePost(nodes);
        return root;
    }


    /**
     * @description 把一棵二叉树序列化成字符串【层次】遍历
     * @createTime 2023/3/8 22:24
     */
    public static String serializeLevelTraverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    /**
     * @description 反序列化【层次】遍历
     * @createTime 2023/3/9 10:09
     */
    public static TreeNode deserializeLevel(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        // 第一个元素就是根节点root
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            // 队列中存的都是父节点
            TreeNode parent = queue.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }

}
