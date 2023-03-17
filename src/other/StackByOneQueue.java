package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xie Zexian
 * @description 使用一个队列实现栈
 * @createTime 2023/3/17 10:44
 */
public class StackByOneQueue {

    private Queue<Integer> queue;

    private int topNum = 0;

    public StackByOneQueue() {
        queue = new LinkedList<>();
    }

    /**
     * @description 将元素x压入栈顶
     * @createTime 2023/3/17 10:48
     */
    public void push(int x) {
        queue.offer(x);
        topNum = x;
    }

    /**
     * @description 移除并返回栈顶元素
     * @createTime 2023/3/17 10:47
     */
    public int pop() {
        int size = queue.size();
        // 留下队尾两个元素
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        // 记录新的队尾元素
        topNum = queue.peek();
        queue.offer(queue.poll());
        // 删除之前的队尾元素
        return queue.poll();
    }

    /**
     * @description 返回栈顶元素
     * @createTime 2023/3/17 10:48
     */
    public int top() {
        return topNum;
    }

    /**
     * @description 返回栈是否空
     * @createTime 2023/3/17 10:48
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
