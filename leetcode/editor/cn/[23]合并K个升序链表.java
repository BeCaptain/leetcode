
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class linkedlist.ListNode {
 * int val;
 * linkedlist.ListNode next;
 * linkedlist.ListNode() {}
 * linkedlist.ListNode(int val) { this.val = val; }
 * linkedlist.ListNode(int val, linkedlist.ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0), p = dummy;
        // 优先队列 --> 小顶堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                // PriorityQueue会在比较结果大于0的时候把第一个数下沉
                lists.length, (o1, o2) -> o1.val - o2.val
        );
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
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
//leetcode submit region end(Prohibit modification and deletion)
