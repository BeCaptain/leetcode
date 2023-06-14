package str;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/3/23 21:50
 */
public class StrTest {
    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(reverseStr(s, 3));
    }

    /**
     * @description 541.反转字符串
     * @createTime 2023/6/14 10:08
     */

    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            right--;
            left++;
        }
    }

    /**
     * @description 20.有效的括号
     * @createTime 2023/3/23 22:15
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
