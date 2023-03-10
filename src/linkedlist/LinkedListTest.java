package linkedlist;

import linkedlist.LinkedList;
import linkedlist.ListNode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Xie Zexian
 * @description 链表测试类
 * @createTime 2023/1/29 21:27
 */
public class LinkedListTest {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("slow = " + slow.val);
        System.out.println("fast = " + fast.val);

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


}

