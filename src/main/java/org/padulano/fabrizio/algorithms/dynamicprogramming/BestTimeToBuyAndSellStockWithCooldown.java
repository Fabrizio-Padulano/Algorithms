package org.padulano.fabrizio.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        return dfs(prices, 0, new HashMap<>(), true);
    }

    private static int dfs(int[] prices, int i, Map<String, Integer> cache, boolean buying) {
        if(i >= prices.length) return 0;

        String key = i + "" + buying;

        if(cache.containsKey(key)) return cache.get(key);

        int cd = dfs(prices, i + 1, cache, buying);
        if(buying) {
            int buy = dfs(prices, i + 1, cache, false) - prices[i];
            cache.put(key, Math.max(buy, cd));
        }
        else {
            int sell = dfs(prices, i + 2, cache, true) + prices[i];
            cache.put(key, Math.max(sell, cd));
        }

        return cache.get(key);
    }
}
