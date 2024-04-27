package org.padulano.fabrizio.algorithms.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class UniquePowerSet {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();

        dfs(0, nums, new ArrayList<>(), subsets);

        return subsets;
    }

    private static void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if(i >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        i++;
        dfs(i, nums, subset, subsets);

        subset.remove(subset.size() - 1);
        while(i > 0 && i < nums.length && nums[i] == nums[i - 1]) i++;
        dfs(i, nums, subset, subsets);
    }
}
