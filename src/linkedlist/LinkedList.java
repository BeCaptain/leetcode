package linkedlist;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Xie Zexian
 * @description 自定义链表类
 * @createTime 2023/1/29 22:17
 */
public class LinkedList {

    int size;
    ListNode head;

    public LinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            ListNode temp = this.head;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
    }

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public void print() {
        ListNode temp = this.head;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            temp = temp.next;
            list.add(temp.val);
        }
        System.out.println(StringUtils.join(list, " -> "));
    }

    public void addArray(int[] nums) {
        for (int i : nums) {
            this.addAtTail(i);
        }
    }

}
