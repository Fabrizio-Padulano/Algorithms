package org.padulano.fabrizio.algorithms.dynamicprogramming;

//https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length()+1];

        for(int i = 0; i < dp.length; i++) {
            dp[i][text2.length()] = 0;
        }

        for(int i = 0; i < text2.length(); i++) {
            dp[text1.length()][i] = 0;
        }

        for(int i = dp.length - 2; i >= 0; i--) {
            for(int j = dp[0].length - 2; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
