package bfs;

import java.util.*;

/**
 * @author Xie Zexian
 * @description 密码锁
 * @createTime 2023/3/3 11:28
 */
public class Lock {

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(BFS(deadends, target));
    }

    // 将s[j]向上拨动
    public static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    // 将s[j]向下拨动
    public static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    public static int BFS(String[] deadends, String target) {
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // 判断是否到达重点
                if (target.equals(cur)) {
                    return step;
                }
                // 将cur的相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }

            step++;
        }
        return -1;
    }
}
