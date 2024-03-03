package org.padulano.fabrizio.algorithms.twopointers;

import java.util.HashSet;
import java.util.Set;

/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, res = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            res = Math.max(res, set.size());
            r++;
        }

        return res;
    }
}
