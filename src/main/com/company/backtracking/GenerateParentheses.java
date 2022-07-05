package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Generate Parentheses
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 *
 * Explanation:
 * Recursively pass and check opening and closing parentheses counts.
 * Delete previous character after each step.
 *
 * Time complexity : O(4*n/sqrt(n)).
 * Space complexity : O(4*n/sqrt(n)).
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses app = new GenerateParentheses();
        assertEquals(List.of("((()))","(()())","(())()","()(())","()()()"), app.generateParenthesis(3));
        assertEquals(List.of("(())","()()"), app.generateParenthesis(2));
        assertEquals(List.of("()"), app.generateParenthesis(1));
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
