package org.padulano.fabrizio.algorithms.twopointers;

/*
  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int l = 0, r = 0, max = 0;

        while (r < prices.length) {
            if (prices[l] >= prices[r]) {
                l = r;
                r++;
            } else {
                max = Math.max(max, prices[r] - prices[l]);
                r++;
            }
        }

        return max;
    }
}
