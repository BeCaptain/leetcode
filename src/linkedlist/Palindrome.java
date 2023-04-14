package linkedlist;

import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 回文链表
 * @createTime 2023/4/14 15:48
 */
public class Palindrome {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(isPalindrome1(head));
        System.out.println(isPalindrome2(head));
        System.out.println(isPalindrome3(head));
    }

    /**
     * @description 234.回文链表 --- Stack
     * @createTime 2023/3/4 21:43
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * @description 回文链表 --- 递归的堆栈
     * @createTime 2023/4/14 15:53
     */
    public static boolean isPalindrome2(ListNode head) {
        left = head;
        return traverse(head);
    }

    private static ListNode left;

    private static boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    /**
     * @description 回文链表 --- 找中点 + 反转链表
     * @createTime 2023/4/14 15:58
     */
    public static boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
        // 找链表中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 节点数为奇数
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
