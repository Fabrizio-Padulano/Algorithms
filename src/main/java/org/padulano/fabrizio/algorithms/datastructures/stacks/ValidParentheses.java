package org.padulano.fabrizio.algorithms.datastructures.stacks;

import java.util.Map;
import java.util.Stack;

/**
 * Input: grid = s = "()[]{}"
 * Output: true;
 *
 * Input: s = "(]"
 * Output: false;
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if((s.length() % 2) != 0) return false;

        Map<Character, Character> brackets = Map.of(
                '}', '{',
                ']', '[',
                ')', '('
        );

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(brackets.containsKey(c)) {
                if(stack.isEmpty() || stack.pop() != brackets.get(c)) return false;
            } else stack.add(c);

        }

        return stack.isEmpty();
    }
}
