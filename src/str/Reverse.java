package str;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Xie Zexian
 * @description 字符串反转
 * @createTime 2023/3/6 13:48
 */
public class Reverse {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("[ ]+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static String reverse(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

}
