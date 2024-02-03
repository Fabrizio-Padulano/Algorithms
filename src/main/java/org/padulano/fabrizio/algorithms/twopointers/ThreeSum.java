package org.padulano.fabrizio.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    /**
     * Please see https://leetcode.com/problems/3sum/ for information
     * @params  e.g [[1,2],[1,3],[2,3]];
     */
    public static  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(i, nums, res);
        }

        return res;
    }

    private static void twoSum(int i, int[] nums, List<List<Integer>> res) {
        int l = i + 1, r = nums.length - 1;

        while(l < r) {
            int sum = nums[i] + nums[l] + nums[r];

            if(sum == 0) res.add(List.of(nums[i], nums[l], nums[r]));

            if(sum > 0) {
                r--;
            } else {
                l++;
                while(l < nums.length && nums[l] == nums[l-1]) l++;
            }
        }
    }
}
