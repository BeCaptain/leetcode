package str;

import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 数组去重
 * @createTime 2023/3/7 11:31
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "bcabc";
        String result = removeDuplicateLetters(s);
        System.out.println("result = " + result);
    }

    /**
     * @description 316.去除重复字母, 保证字典序最小
     * @createTime 2023/3/7 14:51
     */
    public static String removeDuplicateLetters(String s) {
        // 存放去重的结果
        Stack<Character> stack = new Stack<>();
        // 记录栈中是否存在某个字符
        // 输入字符均为ASCII字符，256够用
        boolean[] inStack = new boolean[256];

        // 计数器：记录字符的数量
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 每遍历一个字符，都要将对应的计数减一
            count[c]--;

            if (inStack[c]) {
                continue;
            }
            // 插入元素之前，和之前的元素比较一下大小
            // 如果字典序比前面的小，pop前面的元素
            while (!stack.isEmpty() && stack.peek() > c) {
                // 若之后不存在栈顶元素了，则停止pop
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        // 栈中元素插入顺序是反的，需要reverse
        return res.reverse().toString();
    }

}
