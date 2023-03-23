package graph;

import java.util.*;

/**
 * @author Xie Zexian
 * @description Dijkstra
 * @createTime 2023/3/16 19:20
 */
public class Dijkstra {
    public static void main(String[] args) {

    }

    /**
     * @description 返回节点from到节点to之间的边的权重
     * @createTime 2023/3/16 19:39
     */
    public static int weight(int from, int to) {
        return 0;
    }

    /**
     * @description 返回节点s的相邻节点
     * @createTime 2023/3/16 19:39
     */
    public static List<Integer> adj(int s) {
        return new ArrayList<>();
    }

    /**
     * @param start:起点, graph：图
     * @description 计算start到其他节点的最短距离
     * @createTime 2023/3/16 19:40
     */
    public static int[] dijkstra(int start, List<Integer>[] graph) {
        // 图中节点的个数
        int v = graph.length;
        // distTo[i]：指节点start到节点i的最短路径权重 (可以理解为dp table)
        int[] distTo = new int[v];
        // 求最小值，所以初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // start -> start 的最短距离是0
        distTo[start] = 0;
        // 优先队列，distFromStart比较小的排前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> (a.distFromStart - b.distFromStart));
        // 从起点start开始BFS
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeId = curState.id;
            int curDistFromStart = curState.distFromStart;
            // 已经有一条更短的路径到达curNode节点了
            if (curDistFromStart > distTo[curNodeId]) {
                continue;
            }
            for (int nextNodeId : adj(curNodeId)) {
                int distToNextNode = distTo[curNodeId] + weight(curNodeId, nextNodeId);
                if (distTo[nextNodeId] > distToNextNode) {
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }

        }
        return distTo;
    }

    static class State {
        // 图节点的id
        int id;
        // 从start节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
}
