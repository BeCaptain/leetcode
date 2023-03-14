package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 扁平化嵌套列表迭代器
 * @createTime 2023/3/14 16:31
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> list) {
        /*
         * 一次性算出了所有叶子节点的值，全部装到result列表，也就是内存中
         * next和hasNext方法只是对result列表做迭代，如果输入规模非常大，则计算会很慢而且很占用内存
         * 一般的迭代器求值应该是【惰性的】，要一个结果就算一个(一小部分)结果，而不是把所有结果都算出来
         * 公众号有进阶思路
         */
        List<Integer> res = new LinkedList<>();
        for (NestedInteger node : list) {
            traverse(node, res);
        }
        this.iterator = res.iterator();
    }

    private void traverse(NestedInteger root, List<Integer> result) {
        if (root.isInteger()) {
            result.add(root.getInteger());
            return;
        }
        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val) {
            this.val = val;
            this.list = null;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.val = null;
            this.list = list;
        }

        // 如果其中存的是一个整数，则返回true，否则返回false
        public boolean isInteger() {
            return val != null;
        }

        // 如果其中存的是一个整数，则返回这个整数，否则返回null
        public Integer getInteger() {
            return this.val;
        }

        // 如果其中存的是一个列表，则返回这个列表，否则返回null
        public List<NestedInteger> getList() {
            return this.list;
        }

    }
}
