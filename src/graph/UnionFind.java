package graph;

/**
 * @author Xie Zexian
 * @description 并查集
 * @createTime 2023/3/15 10:45
 */
public class UnionFind {
    /**
     * @description 记录连通分量个数
     */
    private int count;

    /**
     * @description 节点x的父节点是parent[x]
     */
    private int[] parent;

    /**
     * @description 构造方法
     * @createTime 2023/3/15 12:52
     */
    public UnionFind(int n) {
        // 开始互不连通
        this.count = n;
        // 父节点指针初始化指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * @description 连通节点p和q (将任意一个节点的根节点指向另一个节点的根节点)
     * @createTime 2023/3/15 11:57
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // 将两棵树合并
        parent[rootP] = rootQ;
        // parent[rootQ] = rootP 也一样
        // 连通分量减一
        count--;
    }

    /**
     * @description 返回节点x的根节点
     * @createTime 2023/3/15 11:55
     */
    public int find(int x) {
        // 路径压缩!!!  --> 保证任意树的高度保持在常数，使得各个API时间复杂度为 O(1)
        // 可以直接把一整棵树压平
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * @description 判断节点p和q是否连通 (是否有相同的根节点)
     * @createTime 2023/3/15 12:51
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
