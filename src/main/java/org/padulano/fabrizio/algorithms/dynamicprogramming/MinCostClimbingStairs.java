package org.padulano.fabrizio.algorithms.dynamicprogramming;

//https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    /*
    *  Constraints: 2 <= cost.length <= 1000
    * */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[dp.length - 1] = 0;
        dp[dp.length - 2] = cost[cost.length - 1];

        for(int i = dp.length - 3; i >= 0; i--)  {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}
