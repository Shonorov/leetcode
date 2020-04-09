package com.company.challange;

import java.util.Stack;

/**
 * Backspace String Compare
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac"
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become ""
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Explanation:
 * Truncate all existing "#" with previous char and then compare.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String[] test = {"ab#c", "ad#c"};
        String[] test2 = {"ab##", "c#d#"};
        String[] test3 = {"a##c", "#a#c"};
        String[] test4 = {"a#c", "b"};
        System.out.println(backspaceStringCompare.backspaceCompare(test[0], test[1])); //true
        System.out.println(backspaceStringCompare.backspaceCompare(test2[0], test2[1])); //true
        System.out.println(backspaceStringCompare.backspaceCompare(test3[0], test3[1])); //true
        System.out.println(backspaceStringCompare.backspaceCompare(test4[0], test4[1])); //false
    }

    private boolean backspaceCompare(String S, String T) {
        while (S.contains("#") || T.contains("#")) {
            S = processBackspace(S);
            T = processBackspace(T);
        }
        return S.equals(T);
    }

    private String processBackspace(String str) {
        if (str.contains("#")) {
            str = (str.indexOf("#") > 0) ?
                    (str.substring(0, str.indexOf("#") - 1) + str.substring(str.indexOf("#") + 1)) :
                    str.substring(str.indexOf("#") + 1);
        }
        return str;
    }

    /**
     * Stack solution
     */
    public boolean backspaceCompareStack(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String S) {
        Stack<Character> ans = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
