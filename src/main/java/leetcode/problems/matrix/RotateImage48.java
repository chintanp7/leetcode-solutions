package leetcode.problems.matrix;

import java.util.Arrays;

public class RotateImage48 {
    public static void main(String[] args) {
        RotateImage48 obj = new RotateImage48();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        obj.rotate(matrix);
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] visited = new int[n][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, 0);
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && visited[j][i] == 0) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    visited[i][j] = 1;
                    visited[j][i] = 1;
                }
            }
        }*/

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        System.out.println(matrix);
    }
}
