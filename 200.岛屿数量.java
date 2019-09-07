import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */
class Solution {
    int size;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char curr = grid[i][j];
                if (curr == '1') {
                    size++;
                    helper(grid, i, j);
                }

            }
        }
        return size;
    }

    public void helper(char[][] grid, int i, int j) {
        char curr = grid[i][j];
        if (curr == '2' || curr == '1') {
            // 把周围的1标记成2

            if (i > 0) {
                grid[i - 1][j] = grid[i - 1][j] == '1' ? '2' : '0';
                helper(grid, i - 1, j);
            }
            if (i < grid.length - 1) {
                grid[i + 1][j] = grid[i + 1][j] == '1' ? '2' : '0';
                helper(grid, i + 1, j);
            }
            if (j > 0) {
                grid[i][j - 1] = grid[i][j - 1] == '1' ? '2' : '0';
                helper(grid, i, j - 1);
            }
            if (j < grid[0].length - 1) {
                grid[i][j + 1] = grid[i][j + 1] == '1' ? '2' : '0';
                helper(grid, i, j + 1);
            }
        }
    }
}
