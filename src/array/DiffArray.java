package array;

/**
 * @author Xie Zexian
 * @description 差分数组
 * @createTime 2023/3/6 11:09
 */
public class DiffArray {
    public static void main(String[] args) {
        int[][] bookings = new int[][]{{9, 0, 1}, {3, 3, 7}};
        System.out.println(carPooling(bookings, 4));
    }
    

    /**
     * @description 1094.拼车
     * @createTime 2023/3/6 11:54
     */
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int i = trip[1];
            // 下车座位就空了
            int j = trip[2] - 1;
            int val = trip[0];
            diff[i] += val;
            if (j < 1000) {
                diff[j + 1] -= val;
            }
        }
        int[] res = new int[1001];
        res[0] = diff[0];
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < 1001; i++) {
            res[i] = res[i - 1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description 109.航班预定统计
     * @createTime 2023/3/6 11:19
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分数组
        int[] diff = new int[n];
        for (int[] book : bookings) {
            int i = book[0], j = book[1];
            diff[i - 1] += book[2];
            if (j < n) {
                diff[j] -= book[2];
            }
        }
        // 差分数组 ---> 原始数组
        int[] answer = new int[n];
        answer[0] = diff[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + diff[i];
        }
        return answer;
    }
}
