package array;

/**
 * @author Xie Zexian
 * @description 双指针数组测试类
 * @createTime 2023/2/24 22:43
 */
public class DoublePointer {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    /**
     * @description 5.最长的回文子串
     * @createTime 2023/2/25 10:59
     */
    public static String longestPalindrome(String s) {
        // 难点：回文串的长度可能是奇数也可能是偶数
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    /**
     * @description 在s中寻找以s[l]和s[r]为中心的最长回文串
     * @createTime 2023/2/25 11:00
     */
    public static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 左右指针向两边展开
            l--;
            r++;
        }
        // l + 1: l--可能会到-1
        return s.substring(l + 1, r);
    }


    /**
     * @description 回文串判断
     * @createTime 2023/2/25 10:43
     */
    public static boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * @description 344.反转字符串
     * @createTime 2023/2/25 10:37
     */
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }

    /**
     * @description 167.两数之和II-输入有序数组
     * @createTime 2023/2/24 22:43
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * @description 26.删除有序数组中的重复项
     * @createTime 2023/2/24 22:45
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            fast++;
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    /**
     * @description 27.移除元素
     * @createTime 2023/2/24 22:46
     */
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    /**
     * @description 283.移动零
     * @createTime 2023/2/24 22:47
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int j = slow; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
