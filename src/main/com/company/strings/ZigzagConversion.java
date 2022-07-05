package com.company.strings;

import static org.junit.Assert.assertEquals;

/**
 * Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 *
 * Explanation:
 * Create array of strings by number of rows.
 * Add letters vertically (0...numRows) then horizontally (numRows - 2...1).
 * Concat all row strings.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion app = new ZigzagConversion();
        assertEquals("PAHNAPLSIIGYIR", app.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", app.convert("PAYPALISHIRING", 4));
        assertEquals("A", app.convert("A", 1));
    }

    public String convert(String s, int numRows) {
        StringBuffer[] matrix = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            matrix[i] = new StringBuffer();
        }
        int i = 0;
        while (i < s.length()) {
            for (int vertical = 0; vertical < numRows && i < s.length(); vertical++) {
                matrix[vertical].append(s.charAt(i++));
            }
            for (int horizontal = numRows - 2; horizontal > 0 && i < s.length(); horizontal--) {
                matrix[horizontal].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
           matrix[0].append(matrix[j]);
        }
        return matrix[0].toString();
    }
}
