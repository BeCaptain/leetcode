package linkedlist;

/**
 * @author Xie Zexian
 * @description 反转链表(递归)
 * @createTime 2023/3/7 16:51
 */
public class Reverse {
    public static void main(String[] args) {
        ListNode head = getLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode newHead = reverseN(head, 3);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    /**
     * @description 206.反转整个链表 --> 递归
     * @createTime 2023/3/7 16:53
     */
    public static ListNode reverseList(ListNode head) {
        // 链表为空或者只有一个节点的时候，反转结果就是它自己
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode successor;

    /**
     * @description 将链表的前 n 个节点反转（n <= 链表长度）
     * @createTime 2023/3/7 17:23
     */
    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * @description 输入一串数组，返回一个单链表
     * @createTime 2023/3/4 10:36
     */
    public static ListNode getLinkedList(int[] nums) {
        LinkedList linkedList = new LinkedList();
        linkedList.addArray(nums);
        return linkedList.head.next;
    }
}
