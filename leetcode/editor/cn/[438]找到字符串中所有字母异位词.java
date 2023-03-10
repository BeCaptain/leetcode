
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            int needCount = need.getOrDefault(c, 0);
            need.put(c, needCount + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                int windowCount = window.getOrDefault(c, 0);
                window.put(c, windowCount + 1);
                //
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
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
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
