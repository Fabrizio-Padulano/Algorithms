package org.padulano.fabrizio.algorithms.binarysearch;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }
}
