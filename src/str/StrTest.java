package str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/3/23 21:50
 */
public class StrTest {
    public static void main(String[] args) {

        System.out.println(isValid("["));
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
