package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Xie Zexian
 * @description Kruskal-MST (最小生成树)
 * @createTime 2023/3/15 21:04
 */
public class Kruskal {
    public static void main(String[] args) {
        int n = 3;
        int[][] connections = new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        minimumCost(n, connections);
    }

    /**
     * @description 1135.最低成本联通所有城市 (MST问题)
     * @createTime 2023/3/16 11:28
     */
    public static int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n + 1);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int weightSum = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }
            uf.union(edge[0], edge[1]);
            weightSum += weight;
        }
        // 由于节点0没有被使用，所以0会额外占据一个连通分量
        return uf.getCount() == 2 ? weightSum : -1;
    }


    /**
     * @description 1584.连接所有点的最小费用 (MST问题)
     * @createTime 2023/3/16 11:46
     */
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 生成边及权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                edges.add(new int[]{i, j, weight});
            }
        }
        UnionFind uf = new UnionFind(n);
        int weightSum = 0;
        // 边按权重从小到大排序
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }
            uf.union(u, v);
            weightSum += weight;
        }
        return weightSum;
    }
}
