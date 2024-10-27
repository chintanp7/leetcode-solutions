package leetcode.problems.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {

    public static void main(String[] args) {
        SpiralMatrix54 obj = new SpiralMatrix54();
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12}};
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        LinkedList<Direction> directions = new LinkedList<>();
        Direction RIGHT = Direction.RIGHT;
        Direction DOWN = Direction.DOWN;
        Direction LEFT = Direction.LEFT;
        Direction UP = Direction.UP;
        RIGHT.setNext(DOWN);
        DOWN.setNext(LEFT);
        LEFT.setNext(UP);
        UP.setNext(RIGHT);
        directions.add(RIGHT);
        directions.add(DOWN);
        directions.add(LEFT);
        directions.add(UP);

        int[][] usage = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < usage.length; i++) {
            Arrays.fill(usage[i], 0);
        }

        Direction direction = RIGHT;
        int end = matrix.length * matrix[0].length;
        int start = 0;
        int i = 0, j = 0;

        while (start < end) {
            result.add(matrix[i][j]);
            usage[i][j] = 1;

        }
        return null;
    }

}


enum Direction {
    RIGHT (0, 1, null),
    DOWN (1, 0, null),
    LEFT (0, -1, null),
    UP (-1,0, null);

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setNext(Direction next) {
        this.next = next;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public Direction getNext() {
        return next;
    }

    private int i;
    private int j;
    private Direction next;

    private Direction(int i, int j, Direction next) {
        this.i = i;
        this.j = j;
        this.next = next;
    }

}