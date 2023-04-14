package array;

/**
 * @author Xie Zexian
 * @description 差分数组工具类
 * @createTime 2023/4/14 17:06
 */
public class DifferenceArray {
    /**
     * 差分数组
     */
    private int[] diff;

    public DifferenceArray(int[] nums) {
        int n = nums.length;
        diff = new int[n];
        // 根据初始数组构建差分数组
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * @description 闭区间 [i, j] 增加value(可以是负数)
     * @createTime 2023/4/14 17:10
     */
    public void increment(int i, int j, int value) {
        diff[i] += value;
        // 当 j + 1 >= diff.length时，说明是对nums[i]及以后的整个数组都进行修改，那么就不需要再给diff数组减value了
        if (j + 1 < diff.length) {
            diff[j + 1] -= value;
        }
    }

    /**
     * @description 返回结果数组
     * @createTime 2023/4/14 17:12
     */
    public int[] getResult() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}
