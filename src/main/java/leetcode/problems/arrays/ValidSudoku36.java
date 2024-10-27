package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

    public static void main(String[] args) {
        ValidSudoku36 obj = new ValidSudoku36();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Ans: " + obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (num < 49 || num > 57) {
                        return false;
                    }
                    if (!rowMap.containsKey(i)) {
                        rowMap.put(i, new HashSet<>());
                    }
                    if (!colMap.containsKey(j)) {
                        colMap.put(j, new HashSet<>());
                    }
                    int box = findBox(i, j);
                    if (!boxMap.containsKey(box)) {
                        boxMap.put(box, new HashSet<>());
                    }
                    if (!rowMap.get(i).add(num) || !colMap.get(j).add(num) || !boxMap.get(box).add(num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int findBox(int i, int j) {
        if (i < 3) {
            if (j < 3) {
                return 1;
            }
            if (j < 6) {
                return 2;
            }
            return 3;
        }
        if (i < 6) {
            if (j < 3) {
                return 4;
            }
            if (j < 6) {
                return 5;
            }
            return 6;
        } else {
            if (j < 3) {
                return 7;
            }
            if (j < 6) {
                return 8;
            }
            return 9;
        }
    }
}
