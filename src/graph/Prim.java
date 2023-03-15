package graph;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xie Zexian
 * @description Prim-MST (最小生成树)
 * @createTime 2023/3/15 21:20
 */
public class Prim {

    /**
     * @description 核心数据结构，存储【横切边】
     */
    private PriorityQueue<int[]> pq;

    /**
     * @description 记录哪些顶点已经是MST的一部分了
     */
    private boolean[] inMST;

    /**
     * @description 记录MST的权重之和
     */
    private int weightSum = 0;

    /**
     * @description graph是邻接表表示的图，graph[s]记录顶点s所有相邻的边，三元组int[]{from, to, weight}表示一条边
     */
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        // 按照边的权重从小到大排序
        this.pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        // 图中n个顶点
        int n = graph.length;
        this.inMST = new boolean[n];
        // 随便从一个点开始切分
        inMST[0] = true;
        cut(0);
        // 不断进行切分，向MST中添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1], weight = edge[2];
            if (inMST[to]) {
                // 顶点to已经在MST中，跳过
                continue;
            }
            // 将边edge加入MST
            inMST[to] = true;
            weightSum += weight;
            // 顶点to加入后，进行新一轮切分，会产生更多横切边
            cut(to);
        }
    }

    /**
     * @description 将s的横切边加入优先队列
     * @createTime 2023/3/15 21:56
     */
    private void cut(int s) {
        // 遍历s的邻边
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inMST[to]) {
                // 相邻顶点to已经在MST中，跳过
                continue;
            }
            // 加入横切队列
            pq.offer(edge);
        }
    }

    /**
     * @description MST的权重之和
     * @createTime 2023/3/15 22:18
     */
    public int getWeightSum() {
        return weightSum;
    }

    /**
     * @description 判断MST是否已包含图中的所有顶点
     * @createTime 2023/3/15 22:19
     */
    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
