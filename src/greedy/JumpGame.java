package greedy;

/**
 * @author Xie Zexian
 * @description 跳跃游戏
 * @createTime 2023/4/2 17:06
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    /**
     * @description 55.跳跃游戏
     * @createTime 2023/4/2 17:07
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了0，卡住跳不动了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
