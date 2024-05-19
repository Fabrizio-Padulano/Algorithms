package org.padulano.fabrizio.algorithms.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) continue;
                dp[i] = Math.max(dp[i], 1 + dp[j]);
                result = Math.max(result, dp[i]);
            }
        }

        return result;
    }
}
