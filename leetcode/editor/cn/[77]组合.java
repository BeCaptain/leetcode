
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> res = new LinkedList<>();

    public LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public void backtrack(int n, int k, int start) {
        // 结束条件
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            backtrack(n, k, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
