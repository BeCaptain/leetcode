
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int needCount = need.getOrDefault(c, 0);
            need.put(c, needCount + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                int windowCount = window.getOrDefault(c, 0);
                window.put(c, windowCount + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // whether to shrink or not
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    int dCount = window.get(d);
                    window.put(d, dCount - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
