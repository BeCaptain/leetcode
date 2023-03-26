package linkedlist;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 链表测试类
 * @createTime 2023/1/29 21:27
 */
public class LinkedListTest {
    public static void main(String[] args) {

        ListNode l1 = LinkedListUtils.getLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = LinkedListUtils.getLinkedList(new int[]{9, 9, 9, 9});

        ListNode res = addTwoNumbers(l1, l2);
        LinkedListUtils.print(res);


    }

    /**
     * @description 234.回文链表
     * @createTime 2023/3/4 21:43
     */
    public static boolean isPalindrome(ListNode head) {
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
     * @description 206.反转链表
     * @createTime 2023/3/4 10:40
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * @description 23.合并K个升序链表
     * @createTime 2023/2/24 22:52
     */
    public static ListNode mergeKList(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0), p = dummy;
        // 优先队列 --> 小顶堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (o1, o2) -> o1.val - o2.val
        );
        for (ListNode head : lists) {
            priorityQueue.add(head);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode minNode = priorityQueue.poll();
            p.next = minNode;
            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * @description 2.两数相加
     * @createTime 2023/3/23 21:22
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (p1 != null || p2 != null || carry > 0) {
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            carry = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
        }
        return dummy.next;
    }

}

