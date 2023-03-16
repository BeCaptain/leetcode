package other;

/**
 * @author Xie Zexian
 * @description 二分查找
 * @createTime 2023/2/23 22:05
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 3, 5, 7};
        System.out.println(rightBound(array, 4));
    }

    /**
     * @description 1011.在D天内送达包裹的能力
     * @createTime 2023/2/24 21:54
     */
    public static int shipWithinDays(int[] weights, int days) {
        // 最小/大载重
        int left = 0;
        int right = 0;
        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int needDays = fShipWithinDays(weights, mid);
            if (needDays <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int fShipWithinDays(int[] weights, int x) {
        int days = 0;
        // Do not increase i in for loop !!
        for (int i = 0; i < weights.length; ) {
            int capacity = x;
            while (i < weights.length) {
                if (capacity < weights[i]) {
                    break;
                } else {
                    capacity -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }

    /**
     * @description 875.爱吃香蕉的珂珂
     * @createTime 2023/2/24 19:12
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int targetTime = h;
        // 珂珂吃香蕉的最慢/快速度
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // 最小速度 ---> 左侧边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int costTime = fMinEatingSpeed(piles, mid);
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

    private static int fMinEatingSpeed(int[] piles, int speed) {
        int costHour = 0;
        for (int p : piles) {
            int hours = p / speed + (p % speed == 0 ? 0 : 1);
            costHour += hours;
        }
        return costHour;
    }

    /**
     * @description 获取数组的最大值
     * @createTime 2023/2/24 19:20
     */
    public static int getArrayMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * @description 获取数组的最小值
     * @createTime 2023/2/24 19:21
     */
    public static int getArrayMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    /**
     * @description 34.在排序数组中查找元素的第一个和最后一个位置
     * @createTime 2023/2/24 19:08
     */
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{-1, -1};
    }

    /**
     * @description 基本的二分搜索
     * @createTime 2023/2/24 19:08
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        // !!!
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        System.out.println("left = " + left + ", right = " + right);
        return -1;
    }

    /**
     * @description 查找左侧边界
     * @createTime 2023/2/24 19:09
     */
    public static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                right = mid - 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        System.out.println("left = " + left);
        return nums[left] == target ? left : -1;
    }

    /**
     * @description 查找右侧边界
     * @createTime 2023/2/24 19:09
     */
    public static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                left = mid + 1;
            }
        }
        if (right < 0) {
            return -1;
        }
        System.out.println("left = " + left + ", right = " + right);
        return nums[right] == target ? right : -1;
    }

}
