
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        // 难点：回文串的长度可能是奇数也可能是偶数
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    public String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 左右指针向两边展开
            l--;
            r++;
        }
        // l + 1: l--可能会到-1
        return s.substring(l + 1, r);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
