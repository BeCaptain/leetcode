package greedy;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 视频拼接
 * @createTime 2023/4/2 16:36
 */
public class VideoStitching {
    public static void main(String[] args) {
        int[][] clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
    }

    /**
     * @description 1024.视频拼接
     * @createTime 2023/4/2 16:37
     */
    public static int videoStitching(int[][] clips, int time) {
        if (time == 0) {
            return 0;
        }
        // 按起点升序排列，起点相同的按结束时间降序排列
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int res = 0;
        int curEnd = 0, nextEnd = 0;
        int i = 0, n = clips.length;
        while (i < n && clips[i][0] <= curEnd) {
            // 在第 res 个视频的区间内贪心选择下一个视频
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            // 找到下一个视频，更新curEnd
            res++;
            curEnd = nextEnd;
            if (curEnd >= time) {
                // 已经可以拼出区间[0, time]
                return res;
            }
        }
        // 无法拼出区间[0, time]
        return -1;
    }
}
