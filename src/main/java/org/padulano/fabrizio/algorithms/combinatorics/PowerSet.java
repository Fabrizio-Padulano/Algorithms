package org.padulano.fabrizio.algorithms.combinatorics;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), powerSet);
        return powerSet;
    }

    private static void dfs(
            int[] nums,
            int i,
            List<Integer> currentSet,
            List<List<Integer>> powerSet
    ) {
        if(i >= nums.length) {
            powerSet.add(new ArrayList<>(currentSet));
            return;
        }

        currentSet.add(nums[i]);
        dfs(nums, i + 1, currentSet, powerSet);

        currentSet.remove(currentSet.size() - 1);
        dfs(nums, i + 1, currentSet, powerSet);
    }
}
