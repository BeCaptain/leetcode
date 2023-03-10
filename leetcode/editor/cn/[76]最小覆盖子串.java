
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            int needCount = need.getOrDefault(c, 0);
            need.put(c, needCount + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int windowCount = window.getOrDefault(c, 0);
                window.put(c, windowCount + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    int d_count = window.get(d);
                    window.put(d, d_count - 1);
                }
            }
        }
        // 如果最小长度还等于初始值，说明没有符合条件的子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
