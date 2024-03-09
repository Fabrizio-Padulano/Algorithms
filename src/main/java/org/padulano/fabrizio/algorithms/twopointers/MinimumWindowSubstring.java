package org.padulano.fabrizio.algorithms.twopointers;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int l = 0, r = 0, max = Integer.MAX_VALUE, resL = -1, resR = -1;

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();


        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = t.length();
        while(r < s.length()) {
            char rChar = s.charAt(r);

            if(tMap.containsKey(rChar)) {
                sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);

                if(sMap.get(rChar) <= tMap.get(rChar)) have++;
            }

            while(have == need) {
                char c = s.charAt(l);
                if(tMap.containsKey(c)) {
                    sMap.put(c, sMap.get(c) - 1);
                    if(sMap.get(c) < tMap.get(c)) have--;
                }

                if(r - l + 1 <= max) {
                    max = r - l + 1;
                    resL = l;
                    resR = r;
                }

                l++;
            }
            r++;
        }

        if(resL == -1) return "";

        return s.substring(resL, resR + 1);
    }
}
