package graph;

import java.util.*;

/**
 * @author Xie Zexian
 * @description 拓扑排序
 * @createTime 2023/3/14 20:02
 */
public class TopologicalSort {
    public static void main(String[] args) {

    }

    /**
     * @description 记录后序遍历的结果
     */
    private static List<Integer> postorder = new ArrayList<>();

    /**
     * @description 210.课程表II (拓扑排序 -- 【DFS】)
     * @createTime 2023/3/14 20:13
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = CycleTest.buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverseDFS(graph, i);
        }
        // 有环图无法进行拓扑排序
        if (hasCycle) {
            return new int[]{};
        }
        // 反转后序遍历结果即为拓扑排序的结果
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    private static boolean[] visited;

    private static boolean[] onPath;

    private static boolean hasCycle;

    private static void traverseDFS(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 发现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }
        // 前序遍历位置
        visited[s] = true;
        onPath[s] = true;

        for (int t : graph[s]) {
            traverseDFS(graph, t);
        }
        // 后序遍历位置
        postorder.add(s);
        onPath[s] = false;
    }

    public static int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = CycleTest.buildGraph(numCourses, prerequisites);
        // 入度数组
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int[] edge : prerequisites) {
                int to = edge[0];
                indegree[to]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        // 记录遍历节点的顺序(索引)
        int count = 0;
        // BFS执行
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count != numCourses) {
            // 存在环
            return new int[]{};
        }
        return res;
    }
}
