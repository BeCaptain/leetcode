
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class linkedlist.ListNode {
 *     int val;
 *     linkedlist.ListNode next;
 *     linkedlist.ListNode() {}
 *     linkedlist.ListNode(int val) { this.val = val; }
 *     linkedlist.ListNode(int val, linkedlist.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
