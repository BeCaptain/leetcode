package other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xie Zexian
 * @description 优先队列测试类
 * @createTime 2023/2/22 17:00
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pr.add(5);
        pr.add(7);
        pr.add(2);
        pr.add(3);
        System.out.println(pr.poll());
    }
}
