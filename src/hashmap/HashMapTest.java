package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/6/6 21:01
 */
public class HashMapTest {
    public static void main(String[] args) {

        String ransomNote = "a";
        String magazine = "aab";
        canConstruct(ransomNote, magazine);
    }

    /**
     * @description 383.赎金信
     * @createTime 2023/6/14 9:49
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
            if (record[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description 202.快乐数
     * @createTime 2023/6/6 22:04
     */
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int squareSum = getSquareSum(n);
            if (squareSum == 1) {
                return true;
            }
            if (set.contains(squareSum)) {
                return false;
            } else {
                set.add(squareSum);
            }
            n = squareSum;
        }
    }

    public static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int number = n % 10;
            sum += number * number;
            n = n / 10;
        }
        return sum;
    }

    /**
     * @description 349.两个数组的交集
     * @createTime 2023/6/6 21:08
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }

    /**
     * @description 242.有效的字母异位词
     * @createTime 2023/6/6 21:01
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index1 = s.charAt(i) - 'a';
            arr1[index1]++;
            int index2 = t.charAt(i) - 'a';
            arr2[index2]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
