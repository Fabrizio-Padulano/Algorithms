package org.padulano.fabrizio.algorithms.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/
public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int[][] memo = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return backtrack(memo, s, t, s.length(), t.length());
    }

    private static int backtrack(int[][] memo, String s, String t, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        if (j == 0) memo[i][j] = 1;
        else if (i == 0) memo[i][j] = 0;
        else {
            int sol1 = backtrack(memo, s, t, i - 1, j);
            int sol2 = 0;
            if (s.charAt(i - 1) == t.charAt(j - 1)) sol2 = backtrack(memo, s, t, i - 1, j - 1);
            memo[i][j] = sol1 + sol2;
        }
        return memo[i][j];
    }
}