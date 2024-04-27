package org.padulano.fabrizio.algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/word-search/description/
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int n = 0; n < board[0].length; n++) {
                if(dfs(board, i, n, word, 0, new HashSet<>())) return true;
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int m, int n, String word, int i, Set<String> visited) {
        final int ROWS = board.length;
        final int COLS = board[0].length;

        boolean rowInBound = m < ROWS && m >= 0;
        boolean colsInBound = n < COLS && n >= 0;

        String position = m + "-" + n;
        if(
                !rowInBound || !colsInBound ||
                        board[m][n] != word.charAt(i) ||
                        visited.contains(position)
        ) return false;

        if(i == word.length()- 1) return true;

        visited.add(position);

        var isValid =
                dfs(board, m+1, n, word, i+1, visited ) ||
                        dfs(board, m-1, n, word, i+1, visited) ||
                        dfs(board, m, n+1, word, i+1, visited) ||
                        dfs(board, m, n-1, word, i+1, visited);

        visited.remove(position);

        return isValid;
    }
}
