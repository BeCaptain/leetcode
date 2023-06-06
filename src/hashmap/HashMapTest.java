package hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/6/6 21:01
 */
public class HashMapTest {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
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
