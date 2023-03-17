package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 使用两个队列实现栈
 * @createTime 2023/3/17 10:44
 */
public class StackByTwoQueue {
    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    public StackByTwoQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * @description 将元素x压入栈顶
     * @createTime 2023/3/17 11:12
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * @description 移除并返回栈顶元素
     * @createTime 2023/3/17 11:12
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * @description 返回栈顶元素
     * @createTime 2023/3/17 11:13
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * @description 返回栈是否空
     * @createTime 2023/3/17 11:13
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
