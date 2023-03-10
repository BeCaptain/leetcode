
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode slow = head, fast = head;
        dummy.next = slow;
        while (fast.next != null) {
            fast = fast.next;
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
        }
        slow.next = null;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
