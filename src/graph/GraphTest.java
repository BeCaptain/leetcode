package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 图
 * @createTime 2023/3/14 17:39
 */
public class GraphTest {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    /**
     * @description 797.所有可能的路径-有向无环图遍历
     * @createTime 2023/3/14 18:51
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /**
     * @description 记录所有路径
     */
    private static List<List<Integer>> res = new LinkedList<>();

    /**
     * @description 图的遍历框架
     * @createTime 2023/3/14 19:03
     */
    private static void traverse(int[][] graph, int s, LinkedList<Integer> path) {
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
            traverse(graph, v, path);
        }
        // 从路径移出节点s
        path.removeLast();
    }
}
