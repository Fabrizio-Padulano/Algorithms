package org.padulano.fabrizio.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
                '2',"abc",
                '3',"def",
                '4',"ghi",
                '5',"jkl",
                '6',"mno",
                '7',"pqrs",
                '8',"tuv",
                '9',"wxyz"
        );

        List<String> combinations = new ArrayList<>();

        if(digits.isEmpty()) return combinations;

        dfs(digits, 0, "", combinations, map);

        return combinations;
    }

    private static void dfs(String digits, int i, String combination, List<String> combinations, Map<Character, String> charMap) {
        if(i >= digits.length()) {
            combinations.add(combination);
            return;
        }

        String letters = charMap.get(digits.charAt(i));

        for(int j = 0; j < letters.length(); j++) {
            combination += letters.charAt(j);
            dfs(digits, i + 1, combination, combinations, charMap);
            combination = combination.substring(0, combination.length() - 1);
        }

    }

}
