package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 滑动窗口测试类
 * @createTime 2023/2/23 13:45
 */
public class SlidingWindow {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * @return int: the length of the longest substring
     * @description 无重复最长子串
     * @createTime 2023/2/23 21:00
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                int dCount = window.get(d);
                window.put(d, dCount - 1);
            }
            maxLen = Math.max(right - left, maxLen);
        }
        return maxLen;
    }

    /**
     * @description 438.找到字符串中所有字母异位词
     * @createTime 2023/2/23 20:39
     */
    public static List<Integer> findAnagrams(String s, String p) {
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

    /**
     * @description 567.字符串的排列
     * @createTime 2023/2/24 19:10
     */
    public static boolean checkInclusion(String s1, String s2) {
        // define two HashMap
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int needCount = need.getOrDefault(c, 0);
            need.put(c, needCount + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                int windowCount = window.getOrDefault(c, 0);
                window.put(c, windowCount + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // whether to shrink or not
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
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
        return false;
    }

    /**
     * @description 滑动窗口框架
     * @createTime 2023/2/24 19:11
     */
    public static String slidingWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : t.toCharArray()) {
            int needCount = need.getOrDefault(c, 0);
            need.put(c, needCount + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int windowCount = window.getOrDefault(c, 0);
                window.put(c, windowCount + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
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
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
