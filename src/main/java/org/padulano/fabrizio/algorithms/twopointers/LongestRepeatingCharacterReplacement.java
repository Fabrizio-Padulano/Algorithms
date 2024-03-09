package org.padulano.fabrizio.algorithms.twopointers;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int l = 0, r = 0, max = 0, result = 0;

        while (r < s.length()) {
            int size = r - l + 1;
            int rCount = count.getOrDefault(s.charAt(r), 0) + 1;
            count.put(s.charAt(r), rCount);

            max = Math.max(max, rCount);

            while (size - max > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
                size = r - l + 1;
            }

            result = Math.max(result, size);

            r++;
        }

        return result;
    }
}
