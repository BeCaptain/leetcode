package linkedlist;

/**
 * @author Xie Zexian
 * @description 单链表节点
 * @createTime 2023/1/29 21:48
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
