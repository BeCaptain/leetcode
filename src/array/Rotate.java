package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xie Zexian
 * @description 二维矩阵旋转
 * @createTime 2023/3/6 14:34
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(matrix);
    }

    /**
     * @description 54.螺旋矩阵
     * @createTime 2023/3/6 18:49
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // m × n: m行n列
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1;
        int upper = 0, bottom = m - 1;
        while (result.size() < m * n) {
            // 上边：从左往右遍历
            if (upper <= bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[upper][i]);
                }
                upper++;
            }
            // 右边：从上往下遍历
            if (left <= right) {
                for (int i = upper; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            // 下边：从右向左遍历
            if (upper <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 左边：从上往下遍历
            if (left <= right) {
                for (int i = bottom; i >= upper; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * @description 48.翻转图像(顺时针)
     * @createTime 2023/3/6 14:38
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 按主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int left = 0, right = n - 1;
        // 对列进行翻转
        while (left <= right) {
            for (int[] row : matrix) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
            }
            left++;
            right--;
        }
    }

    /**
     * @description 打印二维矩阵
     * @createTime 2023/3/6 18:47
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}
