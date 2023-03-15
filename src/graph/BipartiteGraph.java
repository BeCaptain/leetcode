package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 二分图
 * @createTime 2023/3/14 21:56
 */
public class BipartiteGraph {
    public static void main(String[] args) {

    }

    /**
     * @description 记录图是否符合二分图性质
     */
    private static boolean flag = false;

    /**
     * @description 记录图中节点是否被访问过
     */
    private static boolean[] visited;

    /**
     * @description 记录图中节点的颜色, false和true代表两种不同的颜色
     */
    private static boolean[] color;

    /**
     * @param graph: 邻接表
     * @description 785.判断二分图 --> 【DFS】
     * @createTime 2023/3/14 21:59
     */
    public static boolean isBipartite(int[][] graph) {
        // 判断二分图方法：一边遍历节点，一边给节点染色，尝试让每对相邻节点的颜色都不一样
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        // 因为图不一定是连通的，可能存在多个子图
        // 所以要把每个节点作为起点进行一次遍历
        // 如果发现任何一个子图不说二分图，则整个图都不是

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverseDFS(graph, i);
            }
        }
        return flag;
    }

    private static void traverseDFS(int[][] graph, int v) {
        // 已确定不是二分图，直接return
        if (!flag) {
            return;
        }
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                // 相邻节点w没有被访问，应该给节点w涂上和v不同的颜色
                color[w] = !color[v];
                // 记录遍历w
                traverseDFS(graph, w);
            } else {
                // 相邻节点w已经被访问过，根据v和w的颜色判断是否为二分图
                if (color[w] == color[v]) {
                    // 若颜色相同，则此图不是二分图
                    flag = false;
                    return;
                }
            }
        }
    }

    private static void bfs(int[][] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty() && flag) {
            int v = queue.poll();
            // 从节点v向所有相邻节点扩散
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 如果相邻节点没有被访问，那么给节点w涂上和节点v不同的颜色
                    color[w] = !color[v];
                    // 标记w节点，并放入队列
                    visited[w] = true;
                    queue.offer(w);
                } else {
                    // 相邻节点w已经被访问过，判断节点v和w节点的颜色是否相同
                    if (color[v] == color[w]) {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }
}
