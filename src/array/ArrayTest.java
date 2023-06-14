package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/6/7 9:46
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n :
                nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * @description 1.两数之和
     * @createTime 2023/6/7 15:59
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


}
