package com.company.other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Valid Parentheses
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/721/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'
 *
 * Explanation:
 * Add to stack opening brackets and remove if !stack.isEmpty().
 * Check if bracket is closing one removed from stack.
 * Return stack.isEmpty().
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses app = new ValidParentheses();
        System.out.println(app.isValid("()")); // true
        System.out.println(app.isValid("()[]{}")); // true
        System.out.println(app.isValid("(]")); // false
        System.out.println(app.isValid("{{}[][[[]]]}")); // true
        System.out.println(app.isValid("{}[][[[]]]}")); // false
        System.out.println(app.isValid("[")); // false
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.offer(current);
            } else if (!stack.isEmpty()) {
                char previous = stack.pollLast();
                if (!(
                        (current == ')' && previous == '(') ||
                        (current == ']' && previous == '[') ||
                        (current == '}' && previous == '{'))
                ) {
                    return false;
                }
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }

    public boolean isValidSlower(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> brackets = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (brackets.containsKey(current)) {
                stack.offer(current);
            } else if (!stack.isEmpty() ) {
                char previous = stack.pollLast();
                if (brackets.get(previous) != current) {
                    return false;
                }
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }
}
