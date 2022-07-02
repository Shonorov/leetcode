package com.company.array;

import static org.junit.Assert.assertEquals;

/**
 * Count and Say
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/4153/
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * - countAndSay(1) = "1"
 * - countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 *
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 * Example 1:
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 * Example 2:
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * Constraints:
 * 1 <= n <= 30
 *
 * Explanation:
 * Recursively generate String say = countAndSay(n - 1).
 * Iterate by say and store previous character and count.
 * Append to result with StringBuilder.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay app = new CountAndSay();
        assertEquals(app.countAndSay(1), "1");
        assertEquals(app.countAndSay(4), "1211");
        assertEquals(app.countAndSay(10), "13211311123113112211");
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        Character digit = say.charAt(0);
        int count = 1;
        for (int i = 1; i < say.length(); i++) {
            if (say.charAt(i) == digit) {
                count++;
            } else {
                result.append(count);
                result.append(digit);
                count = 1;
                digit = say.charAt(i);
            }
        }
        result.append(count);
        result.append(digit);
        return result.toString();
    }

}
