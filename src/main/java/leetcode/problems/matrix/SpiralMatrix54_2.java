package leetcode.problems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix54_2 {

    public static void main(String[] args) {
        SpiralMatrix54_2 obj = new SpiralMatrix54_2();
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};

        System.out.println(obj.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> returnList = new ArrayList<>();

        int[][] visited = new int[m][n];
        for (int[] ints : visited) {
            Arrays.fill(ints, 0);
        }

        char dir = 'R';
        int start = 0;
        int end = m * n;
        int i = 0, j = 0;
        while (start < end) {
            if (shouldChangeDir(dir, getI(dir, i), getJ(dir, j), m , n, visited)) {
                dir = changeDirection(dir);
            }
            returnList.add(matrix[i][j]);
            System.out.println(returnList);
            visited[i][j] = 1;
            i = getI(dir, i);
            j = getJ(dir, j);
            start++;
        }
        return returnList;
    }

    private boolean shouldChangeDir(char currentDir, int i, int j, int m, int n, int[][] visited) {

        if (currentDir == 'R' && j >= n) {
            return true;
        }
        if (currentDir == 'D' && i >= m) {
            return true;
        }
        if (currentDir == 'L' && j < 0) {
            return true;
        }
        if (currentDir == 'U' && i < 0) {
            return true;
        }
        if (visited[i][j] == 1) {
            return true;
        }
        return false;
    }

    private char changeDirection(char currentDir) {
        switch (currentDir) {
            case 'R': return 'D';
            case 'D': return 'L';
            case 'L': return 'U';
            case 'U': return 'R';
            default: return 0;
        }
    }

    private int getI(char direction, int i) {
        switch (direction) {
            case 'R':
            case 'L':
                return i;
            case 'D': return i + 1;
            case 'U': return i - 1;
            default: return 0;
        }
    }

    private int getJ(char direction, int j) {
        switch (direction) {
            case 'R': return j + 1;
            case 'D':
            case 'U':
                return j;
            case 'L': return j - 1;
            default: return 0;
        }
    }
}
