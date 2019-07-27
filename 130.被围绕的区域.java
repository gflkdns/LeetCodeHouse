/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */
class Solution {
    int height, width;

    public void solve(char[][] board) {
        height = board.length;
        if (board == null || height == 0) {
            return;
        }
        width = board[0].length;
        if (width == 1 && height == 1) {
            return;
        }

        // top
        for (int i = 0; i < width; i++) {
            dfs(board, 0, i);
        }
        // bottom
        for (int i = 0; i < width; i++) {
            dfs(board, height - 1, i);
        }
        // left
        for (int i = 1; i < height - 1; i++) {
            dfs(board, i, 0);
        }
        // right
        for (int i = 1; i < height - 1; i++) {
            dfs(board, i, width - 1);
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (board[j][i] == 'O') {
                    board[j][i] = 'X';
                } else if (board[j][i] == '-') {
                    board[j][i] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] data, int y, int x) {
        // 越界
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return;
        }
        if (data[y][x] != 'O') {
            return;
        }

        // 边界
        if (x == 0 || y == 0 || y == height - 1 || x == width - 1) {
            data[y][x] = '-';
            dfs(data, y - 1, x);
            dfs(data, y, x - 1);
            dfs(data, y + 1, x);
            dfs(data, y, x + 1);
            return;
        }
        if (data[y - 1][x] == '-' || // 上
                data[y + 1][x] == '-' || // 下
                data[y][x - 1] == '-' || // 左
                data[y][x + 1] == '-'// 右
        ) {
            data[y][x] = '-';
        }
        dfs(data, y - 1, x);
        dfs(data, y, x - 1);
        dfs(data, y + 1, x);
        dfs(data, y, x + 1);
    }
}
