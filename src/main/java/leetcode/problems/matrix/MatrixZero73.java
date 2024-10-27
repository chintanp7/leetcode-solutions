package leetcode.problems.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixZero73 {
    public static void main(String[] args) {
        MatrixZero73 obj = new MatrixZero73();
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        obj.setZeroes2(matrix);
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroI = new HashSet<>();
        Set<Integer> zeroJ = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroI.add(i);
                    zeroJ.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (zeroI.contains(i) || zeroJ.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(matrix);
    }

    public void setZeroes2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, 0);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    for (int x = 0; x < m; x++) {
                        if (matrix[x][j] != 0) {
                            matrix[x][j] = 0;
                            visited[x][j] = 1;
                        }
                    }
                    for (int y = 0; y < n; y++) {
                        if (matrix[i][y] != 0) {
                            matrix[i][y] = 0;
                            visited[i][y] = 1;
                        }
                    }
                }
            }
        }

        System.out.println(matrix);
    }
}
