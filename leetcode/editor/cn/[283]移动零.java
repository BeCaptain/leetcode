
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
