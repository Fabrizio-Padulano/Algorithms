package org.padulano.fabrizio.algorithms.dynamicprogramming;

//https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[dp.length - 1][i] = word2.length() - i;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][dp[0].length - 1] = word1.length() - i;
        }

        return dfs(word1, word2, dp);
    }

    private static int dfs(String word1, String word2, int[][] dp) {
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j + 1], dp[i + 1][j]));
                }
            }
        }

        return dp[0][0];
    }
}
