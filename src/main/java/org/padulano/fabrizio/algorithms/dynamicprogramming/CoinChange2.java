package org.padulano.fabrizio.algorithms.dynamicprogramming;


//https://leetcode.com/problems/coin-change-ii/description/
public class CoinChange2 {

    // I could have also used just an array, without the matrix.
    public int change(int amount, int[] coins) {
        if (coins.length < 1) return 0;

        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i > 0 && j < coins[i]) dp[i][j] = dp[i - 1][j];
                else if (i == 0 && j < coins[i]) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = dp[i][j - coins[i]];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
}
