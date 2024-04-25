package org.padulano.fabrizio.algorithms.combinatorics;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> subsets = new ArrayList<>();

        dfs(0, target, nums, new ArrayList<>(), subsets);

        return subsets;
    }

    private static void dfs(
            int i,
            int target,
            int[] nums,
            List<Integer> subset,
            List<List<Integer>> subsets
    ) {
        if(target < 0 || i >= nums.length) return;

        if(target == 0) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        for(; i < nums.length; i++ ) {
            subset.add(nums[i]);
            dfs(i, target - nums[i], nums, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}
