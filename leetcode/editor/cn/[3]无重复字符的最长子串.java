
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                int dCount = window.get(d);
                window.put(d, dCount - 1);
            }
            maxLen = Math.max(right - left, maxLen);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
