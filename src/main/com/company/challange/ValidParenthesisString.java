package com.company.challange;

/**
 * Valid Parenthesis String
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/
 *
 *  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 *     Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *     Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *     Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *     '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *     An empty string is also valid.
 *
 * Input: "()"
 * Output: True
 *
 * Input: "(*)"
 * Output: True
 *
 * Input: "(*))"
 * Output: True
 *
 * Note: The string size will be in the range [1, 100].
 *
 * Explanation:
 * For balance == 0 of "(":
 * "(": balance += 1;
 * ")": balance -= 1;
 *
 *
 * Time complexity : O(n). n - rotations count
 * Space complexity : O(1).
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString app = new ValidParenthesisString();
        String test = "()";
        String test2 = "(*)";
        String test3 = "(*))";
        System.out.println(app.checkValidString(test)); // True
        System.out.println(app.checkValidString(test2)); // True
        System.out.println(app.checkValidString(test3)); // True

    }

    private boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1; // smallest possible number of open left brackets "c '(' is '('"
            hi += c != ')' ? 1 : -1; // largest possible number of open left brackets "c != ')' can be '('"
            System.out.println(c + " : " + lo + " " + hi);
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}
