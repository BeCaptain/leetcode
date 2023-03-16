package other;

import java.util.Stack;

/**
 * @author Xie Zexian
 * @description (双)栈实现队列
 * @createTime 2023/3/16 21:55
 */
public class QueueByStack {

    private Stack<Integer> s1, s2;

    public QueueByStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * @description 添加元素到队尾
     * @createTime 2023/3/16 21:59
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * @description 删除对头元素并返回
     * @createTime 2023/3/16 22:01
     */
    public int pop() {
        // 先调用peek()保证s2非空
        peek();
        return s2.pop();
    }

    /**
     * @description 返回队头元素
     * @createTime 2023/3/16 21:59
     */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * @description 判断队列是否为空
     * @createTime 2023/3/16 22:02
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
