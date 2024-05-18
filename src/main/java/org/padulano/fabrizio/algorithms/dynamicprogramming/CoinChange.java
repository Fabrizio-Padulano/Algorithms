package org.padulano.fabrizio.algorithms.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[amount] = 0;

        for(int i = amount-1; i >= 0; i--) {
            for(int coin : coins) {
                int sum = i + coin;
                if(sum >= 0 && sum < dp.length) {
                    dp[i] = Math.min(dp[i], 1 + dp[sum]);
                }
            }
        }

        return dp[0] == amount + 1 ? -1 : dp[0];
    }
}
