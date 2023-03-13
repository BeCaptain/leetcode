package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xie Zexian
 * @description N-Queens
 * @createTime 2023/2/27 20:41
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    private static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        // border: 棋盘(n * n)
        String[][] board = new String[n][n];
        // 初始化border
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(board, 0);
        return res;
    }

    public static void backtrack(String[][] board, int row) {
        // 结束条件
        if (row == board.length) {
            List<String> boardList = new ArrayList<>();
            for (String[] strings : board) {
                StringBuilder rowString = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    rowString.append(strings[j]);
                }
                boardList.add(rowString.toString());
            }
            res.add(boardList);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = "Q";
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = ".";
        }
    }

    public static boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查[列]是否有冲突
        for (int i = 0; i <= row; i++) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }
        // 检查右上方(斜线)是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        // 检查左上方(斜线)是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }

}
