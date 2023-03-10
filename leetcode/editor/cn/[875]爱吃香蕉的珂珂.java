
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int targetTime = h;
        // 珂珂吃香蕉的最慢/快速度
        int left = 1;
        int right = 10e9;

        // 最小速度 ---> 左侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int costTime = f_minEatingSpeed(piles, mid);
            if (targetTime < costTime) {
                left = mid + 1;
            } else if (targetTime > costTime) {
                right = mid - 1;
            } else if (targetTime == costTime) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int f_minEatingSpeed(int[] piles, int speed) {
        int costHour = 0;
        for (int p : piles) {
            int hours = p / speed + (p % speed == 0 ? 0 : 1);
            costHour += hours;
        }
        return costHour;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
