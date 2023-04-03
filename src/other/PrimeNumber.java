package other;

import java.util.Arrays;

/**
 * @author Xie Zexian
 * @description 素数
 * @createTime 2023/4/3 20:16
 */
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(countPrimes(16));
    }

    /**
     * @description 204.计算[1..n]中的素数个数
     * @createTime 2023/4/3 20:20
     */
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        // 初始化为true
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // i的倍数不可能是素数了
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
