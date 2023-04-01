import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 测试类
 * @createTime 2023/2/22 21:37
 */
public class Test {
    public static void main(String[] args) {

        letterCombinations("");
        System.out.println(res);
    }

    public static String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> res = new LinkedList<>();

    public static LinkedList<Character> track = new LinkedList<>();

    public static List<String> letterCombinations(String digits) {
        backtrack(digits, 0);
        return res;
    }

    public static void backtrack(String digits, int start) {
        if (track.size() == digits.length()) {
            res.add(linkedListToString(track));
            return;
        }
        for (char c : getCharacters(digits, start).toCharArray()) {
            track.add(c);
            backtrack(digits, start + 1);
            track.removeLast();
        }

    }

    public static String getCharacters(String digits, int index) {
        char c = digits.charAt(index);
        int number = Integer.parseInt(String.valueOf(c));
        return dict[number];
    }

    public static String linkedListToString(LinkedList<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }


}
