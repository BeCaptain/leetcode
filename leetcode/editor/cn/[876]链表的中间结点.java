
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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
