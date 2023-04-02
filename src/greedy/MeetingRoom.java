package greedy;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 安排会议室
 * @createTime 2023/4/2 16:10
 */
public class MeetingRoom {
    public static void main(String[] args) {

    }

    /**
     * @description 253.会议室II -- 求最多有几个重叠区间(扫描线技巧)
     * @createTime 2023/4/2 16:15
     */
    public static int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        // 把左端点和右端点单独拿出来
        for (int i = 0; i < n; i++) {
            begin[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int count = 0;
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
