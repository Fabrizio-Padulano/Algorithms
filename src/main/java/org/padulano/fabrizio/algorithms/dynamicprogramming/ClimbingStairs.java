package org.padulano.fabrizio.algorithms.dynamicprogramming;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    //create a decision tree and for each sub-problem store the answer into dp array
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[n] = 1;
        dp[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];
    }
}
