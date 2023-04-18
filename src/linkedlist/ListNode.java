package linkedlist;

/**
 * @author Xie Zexian
 * @description 单链表节点
 * @createTime 2023/1/29 21:48
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
