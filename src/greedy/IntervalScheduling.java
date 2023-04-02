package greedy;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 区间调度
 * @createTime 2023/4/2 15:39
 */
public class IntervalScheduling {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(intervalSchedule(intervals));
    }

    public static int intervalSchedule(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按结束时间end升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        // 至少有一个区间不相交
        int count = 1;
        int xEnd = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }
}
