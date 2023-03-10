package dp;

/**
 * @author Xie Zexian
 * @description TODO
 * @createTime 2023/2/26 22:18
 */
public class FibNumber {
    public static void main(String[] args) {
        System.out.println(optiFibDownTopMemo(0));
    }

    /**
     * @description 普通递归(存在大量重复计算) 自顶向下
     * @createTime 2023/2/27 10:49
     */
    public static int regularFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return regularFib(n - 1) + regularFib(n - 2);
    }


    public static int[] memo = new int[10];

    /**
     * @description 递归：自顶向下+备忘录
     * @createTime 2023/2/27 10:56
     */
    public static int fibTopDownMemo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibTopDownMemo(n - 1) + fibTopDownMemo(n - 2);
        return memo[n];
    }

    /**
     * @description 迭代：自底向上+备忘录
     * @createTime 2023/2/27 11:12
     */
    public static int fibDownTopMemo(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * @description 递推：自底向上+优化备忘录(只需存储f(n-1)和f(n-2))
     * @createTime 2023/2/27 11:43
     */
    public static int optiFibDownTopMemo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // memo[0]: f(n - 2), memo[1]: f(n - 1)
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            int temp = memo[1];
            memo[1] = memo[0] + memo[1];
            memo[0] = temp;
        }
        return memo[0] + memo[1];
    }

}
