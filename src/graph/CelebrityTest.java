package graph;

/**
 * @author Xie Zexian
 * @description 名人问题 (277.搜寻名人)
 * @createTime 2023/3/16 20:46
 */
public class CelebrityTest {
    /**
     * @description 返回i是否认识j
     * @createTime 2023/3/16 20:47
     */
    public boolean knows(int i, int j) {
        return true;
    }

    /**
     * @description 返回【名人】的编号 -- 暴力求解 O(N^2)
     * @createTime 2023/3/16 20:48
     */
    public int findCelebrityBruteForce(int n) {
        for (int cand = 0; cand < n; cand++) {
            int other;
            for (other = 0; other < n; other++) {
                if (cand == other) {
                    continue;
                }
                // 保证其他人都认识cand，且cand不认识任何其他人
                if (knows(cand, other) || knows(cand, other)) {
                    break;
                }
            }
            if (other == n) {
                // 找到名人
                return cand;
            }
        }
        return -1;
    }

    /**
     * @description 返回【名人】的编号 -- 优化解法 O(N)
     * @createTime 2023/3/16 20:48
     */
    public int findCelebrityOpti(int n) {
        // 假设cand是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, cand) || knows(cand, other)) {
                // cand不可能是名人，排除
                // 假设other是名人
                cand = other;
            } else {
                // other不可能是名人，排除
                // 继续假设other是名人
            }
        }
        // 现在的cand是排除后的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) {
                continue;
            }
            // 需要保证其他人都认识cand || cand不认识其他人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        return cand;
    }
}
