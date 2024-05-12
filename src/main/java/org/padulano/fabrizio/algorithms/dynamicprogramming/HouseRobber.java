package org.padulano.fabrizio.algorithms.dynamicprogramming;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[dp.length - 1] = 0;
        dp[dp.length - 2] = nums[nums.length - 1];
        dp[dp.length - 3] = nums[nums.length - 2];

        for (int i = dp.length - 4; i >= 0; i--) {
            dp[i] = nums[i] + Math.max(dp[i + 2], dp[i + 3]);
        }

        return Math.max(dp[0], dp[1]);
    }
}
