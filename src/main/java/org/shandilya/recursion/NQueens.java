package org.shandilya.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] uDiagonal = new int[2*n-1];
        int[] lDiagonal = new int[2*n-1];
        solve(0, board, res, leftRow, uDiagonal, lDiagonal);
        return res;
    }

    private static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] uDiagonal, int[] lDiagonal) {
        if (col == board.length) {
            res.add(make(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lDiagonal[row+col] == 0 && uDiagonal[board.length-1+col-row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lDiagonal[row+col] = 1;
                uDiagonal[board.length-1+col-row] = 1;
                solve(col+1, board, res, leftRow, uDiagonal, lDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lDiagonal[row+col] = 0;
                uDiagonal[board.length-1+col-row] = 0;
            }
        }
    }

    private static List<String> make(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        final List<List<String>> res = solveNQueens(4);
        res.forEach(System.out::println);
    }
}
