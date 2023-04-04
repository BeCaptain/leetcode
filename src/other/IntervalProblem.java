package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 区间相关问题
 * @createTime 2023/4/3 22:11
 */
public class IntervalProblem {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 5}, {4, 9}, {3, 6}};
        removeCoveredIntervals(intervals);
    }

    /**
     * @description 56.合并区间
     * @createTime 2023/4/3 22:18
     */
    public static int[][] merge(int[][] intervals) {
        // 按开始时间排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        // 将排序后的第一个区间加入结果集中
        res.add(intervals[0]);

        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            // 结果区间集的最后一个
            int[] last = res.get(res.size() - 1);
            // 当前结果集与last是相交的
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    /**
     * @description 1288.删除被覆盖区间
     * @createTime 2023/4/4 11:33
     */
    public static int removeCoveredIntervals(int[][] intervals) {
        // 按起点升序排列，起点相同时按终点降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // case1: 找到覆盖区间
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            }
            // case2: 找到相交区间，合并
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            // case3: 完全不相交，更新起点和终点
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - res;
    }

    /**
     * @description 986.区间列表的交集
     * @createTime 2023/4/4 11:49
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            if (a2 >= b1 && b2 >= a1) {
                // 两个区间存在交集
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
