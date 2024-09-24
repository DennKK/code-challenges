package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 36. Valid Sudoku
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class ValidSudoku2 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                String boxKey = (i / 3) + "-" + (j / 3);
                if (!boxes.containsKey(boxKey)) {
                    boxes.put(boxKey, new HashSet<>());
                }

                if (board[i][j] == '.') {
                    continue;
                }

                if (
                        rows.get(i).contains(board[i][j]) ||
                                columns.get(j).contains(board[i][j]) ||
                                boxes.get(boxKey).contains(board[i][j])
                ) {
                    return false;
                }

                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                boxes.get(boxKey).add(board[i][j]);
            }
        }

        return true;
    }
}
