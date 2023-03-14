package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 图中的环检测
 * @createTime 2023/3/14 19:44
 */
public class CycleTest {
    public static void main(String[] args) {

    }

    /**
     * @description 记录是否有环
     */
    private static boolean hasCycle = false;

    /**
     * @description 207.课程表 (判断图中是否有环 -- 【DFS】)
     * @createTime 2023/3/14 19:54
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverseDFS(graph, i);
        }
        return !hasCycle;
    }

    /**
     * @description 构造图 (邻接表)
     * @createTime 2023/3/14 19:48
     */
    protected static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    /**
     * @description 防止重复遍历同一个节点
     */
    private static boolean[] visited;

    /**
     * @description 记录遍历过的节点，防止走回头路
     */
    private static boolean[] onPath;

    /**
     * @description 从节点s开始遍历，同时将遍历过的节点标记为true 【DFS】
     * @createTime 2023/3/14 19:52
     */
    private static void traverseDFS(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            return;
        }
        // 前序遍历位置，将当前节点标记为已遍历
        visited[s] = true;
        onPath[s] = true;

        for (int t : graph[s]) {
            traverseDFS(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }

    /**
     * @description 207.课程表 (判断图中是否有环 -- 【BFS】)
     * @createTime 2023/3/14 20:46
     */
    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }
        // 根据入度初始化队列中的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点i没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                queue.offer(i);
            }
        }
        // 记录遍历的节点个数
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int next : graph[count]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为0，说明next依赖的节点都已被遍历
                    queue.offer(next);
                }
            }
        }
        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }
}
