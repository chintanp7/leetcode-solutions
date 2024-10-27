package leetcode.problems.matrix;

import java.util.Arrays;

public class GameOfLife289 {

    public static void main(String[] args) {
        GameOfLife289 obj = new GameOfLife289();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        obj.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] invert = new int[m][n];
        for (int[] arr : invert) {
            Arrays.fill(arr, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbourSum = neighbourSum(board, m, n, i, j);
                if (board[i][j] == 1) {
                    if (neighbourSum < 2 || neighbourSum > 3) {
                        invert[i][j] = 1;
                    }
                } else if (neighbourSum == 3) {
                    invert[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (invert[i][j] == 1) {
                    board[i][j] = 1 - board[i][j];
                }
            }
        }
        System.out.println(board);
    }

    private int neighbourSum(int[][] board, int m, int n, int i, int j) {
        int sum = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
            sum += board[i - 1][j - 1];
        }
        if (i - 1 >= 0 && j + 1 < n) {
            sum += board[i - 1][j + 1];
        }
        if (i + 1 < m && j - 1 >= 0) {
            sum += board[i + 1][j - 1];
        }
        if (i + 1 < m && j + 1 < n) {
            sum += board[i + 1][j + 1];
        }
        if (i - 1 >= 0) {
            sum += board[i - 1][j];
        }
        if (i + 1 < m) {
            sum += board[i + 1][j];
        }
        if (j - 1 >= 0) {
            sum += board[i][j - 1];
        }
        if (j + 1 < n) {
            sum += board[i][j + 1];
        }
        return sum;
    }
}
