package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 括号生成
 * @createTime 2023/4/3 16:23
 */
public class Parentheses {
    public static void main(String[] args) {

    }

    /**
     * @description 22.括号生成
     * @createTime 2023/4/3 16:36
     */
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为n
        backtrack(n, n, track, res);
        return res;
    }

    private static void backtrack(int left, int right, StringBuilder track, List<String> res) {
        // 如果左括号比右括号剩得多，不合法
        if (right < left) {
            return;
        }
        // 数量小于0肯定不合法
        if (left < 0 || right < 0) {
            return;
        }
        // 所有括号都恰好用完时，得到一个合法的括号组会
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        // 尝试放一个左括号
        track.append('(');
        backtrack(left - 1, right, track, res);
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        track.append(')');
        backtrack(left, right - 1, track, res);
        track.deleteCharAt(track.length() - 1);

    }
}
