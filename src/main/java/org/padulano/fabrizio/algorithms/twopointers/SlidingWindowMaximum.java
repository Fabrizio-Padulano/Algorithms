package org.padulano.fabrizio.algorithms.twopointers;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        int r = 0;

        while (r < nums.length) {
            if (!deque.isEmpty() && r > k - 1 && nums[r - k] == deque.peekFirst()) deque.pollFirst();
            while (!deque.isEmpty() && nums[r] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offer(nums[r]);
            if (r >= k - 1) ans[r - k + 1] = deque.peekFirst();
            r++;
        }

        return ans;
    }
}
