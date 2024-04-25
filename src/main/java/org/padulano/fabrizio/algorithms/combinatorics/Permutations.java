package org.padulano.fabrizio.algorithms.combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/permutations/
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();

        dfs(nums, new ArrayList<>(), new HashSet<>(), permutations);

        return permutations;
    }

    private static void dfs(
            int[] nums,
            List<Integer> permutation,
            Set<Integer> permuted,
            List<List<Integer>> permutations
    ) {
        if (permuted.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permuted.contains(nums[i])) continue;
            permuted.add(nums[i]);
            permutation.add(nums[i]);
            dfs(nums, permutation, permuted, permutations);
            permuted.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }
    }
}
