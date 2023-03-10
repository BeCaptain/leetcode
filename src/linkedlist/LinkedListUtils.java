package linkedlist;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 单链表工具类
 * @createTime 2023/3/10 11:47
 */
public class LinkedListUtils {
    /**
     * @description 输入一串数组，返回一个单链表
     * @createTime 2023/3/4 10:36
     */
    public static ListNode getLinkedList(int[] nums) {
        LinkedList linkedList = new LinkedList();
        linkedList.addArray(nums);
        return linkedList.head.next;
    }

    /**
     * @param head: 链表的第一个节点(并非虚拟头节点)
     * @description 打印链表
     * @createTime 2023/3/10 11:53
     */
    public static void print(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(StringUtils.join(list, " -> "));
    }

}
