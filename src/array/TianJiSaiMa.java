package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Xie Zexian
 * @description 田忌赛马
 * @createTime 2023/3/7 10:04
 */
public class TianJiSaiMa {
    public static void main(String[] args) {
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{13, 25, 32, 11};
        int[] result = advantageCount(nums1, nums2);
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * @description 870.优势洗牌
     * @createTime 2023/3/7 10:15
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];

        // nums1升序排列
        Arrays.sort(nums1);
        int left = 0, right = n - 1;

        // 优先队列：降序存储num2
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0], curMax = pair[1];
            if (nums1[right] > curMax) {
                // 比得过，自己上了
                res[i] = nums1[right];
                right--;
            } else {
                // 比不过，用最小值混
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
