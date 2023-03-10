
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            fast++;
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
