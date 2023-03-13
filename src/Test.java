import linkedlist.LinkedListUtils;
import linkedlist.ListNode;

/**
 * @author Xie Zexian
 * @description 测试类
 * @createTime 2023/2/22 21:37
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode head = LinkedListUtils.getLinkedList(nums);
        LinkedListUtils.print(head);

    }
}
