package dfs;

/**
 * @author Xie Zexian
 * @description 岛屿题目
 * @createTime 2023/4/3 15:42
 */
public class Island {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));
    }

    /**
     * @description 200.岛屿数量
     * @createTime 2023/4/3 15:44
     */
    public static int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量+1
                    res++;
                    // 使用dfs将岛屿淹了
                    dfs200(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs200(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs200(grid, i - 1, j);
        dfs200(grid, i + 1, j);
        dfs200(grid, i, j - 1);
        dfs200(grid, i, j + 1);
    }
}
