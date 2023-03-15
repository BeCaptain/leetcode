package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 图
 * @createTime 2023/3/14 17:39
 */
public class GraphTest {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathSourceTargetBFS(graph));
    }

    /**
     * @description 797.所有可能的路径-有向无环图遍历 (DFS)
     * @createTime 2023/3/14 18:51
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverseDFS(graph, 0, path);
        return res;
    }

    /**
     * @description 记录所有路径
     */
    private static List<List<Integer>> res = new LinkedList<>();

    /**
     * @description 图的遍历框架 --> DFS
     * @createTime 2023/3/14 19:03
     */
    private static void traverseDFS(int[][] graph, int s, LinkedList<Integer> path) {
        // 添加节点s到路径
        path.add(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点 (Java函数参数是对象引用!!!)
            res.add(new LinkedList<>(path));
            // 可以直接return，但要removeLast正确维护path
            // path.removeLast();
            // return;
            // 不return也可以，因为图中不包含环，不会出现无限递归
        }
        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverseDFS(graph, v, path);
        }
        // 从路径移出节点s
        path.removeLast();
    }

    /**
     * @description 797.所有可能的路径-有向无环图遍历 (BFS)
     * @createTime 2023/3/15 18:59
     */
    public static List<List<Integer>> allPathSourceTargetBFS(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        int n = graph.length;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<>(Arrays.asList(0)));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> cur = queue.poll();
                int last = cur.get(cur.size() - 1);
                // 遍历到target了
                if (last == n - 1) {
                    res.add(cur);
                    continue;
                }
                for (int num : graph[last]) {
                    List<Integer> list = new LinkedList<>(cur);
                    list.add(num);
                    queue.offer(list);
                }
            }
        }
        return res;
    }
}
