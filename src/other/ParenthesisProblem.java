package other;

import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 括号相关问题
 * @createTime 2023/4/4 16:39
 */
public class ParenthesisProblem {
    public static void main(String[] args) {
        String s = ")))";
        System.out.println(minAddToMakeValid(s));
    }

    /**
     * @description 20.有效的括号
     * @createTime 2023/4/4 16:42
     */
    public static boolean isValid(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 字符c是右括号
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return stack.isEmpty();
    }

    private static char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else {
            return '[';
        }
    }

    /**
     * @description 921.使括号有效的最少添加
     * @createTime 2023/4/4 16:58
     */
    public static int minAddToMakeValid(String s) {
        // 记录插入次数
        int res = 0;
        // 记录右括号的需求量
        int need = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 右括号的需求+1
                need++;
            }
            if (c == ')') {
                // 右括号的需求-1
                need--;
                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }
        return res + need;
    }

}
