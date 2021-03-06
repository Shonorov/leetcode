package com.company.strings;

/**
 * String to Integer (atoi)
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/
 *
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 *
 * Explanation:
 * Trim the string, check length and sign multiplier (shift string start index then).
 * Calculate result until invalid symbol found.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger app = new StringToInteger();
        System.out.println(app.myAtoi("42")); // 42
        System.out.println(app.myAtoi("   -42")); // -42
        System.out.println(app.myAtoi("4193 with words")); // 4193
        System.out.println(app.myAtoi("words and 987")); // 0
        System.out.println(app.myAtoi("")); // 0
        System.out.println(app.myAtoi("-91283472332")); // -2147483648
        System.out.println(app.myAtoi("+1")); // 1
        System.out.println(app.myAtoi("+-2")); // 0
        System.out.println(app.myAtoi("3.14159")); // 3
        System.out.println(app.myAtoi("  -0012a42")); // -12
        System.out.println(app.myAtoi("2147483648")); // 2147483647
    }

    private int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int result = 0, start = 0, sign = 1;
        if (str.charAt(0) == '-') {
            start = 1;
            sign = -1;
        }
        if (str.charAt(0) == '+') {
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (!Character.isDigit(symbol)) break;
            try {
                result = Math.addExact(Math.multiplyExact(result, 10), Character.getNumericValue(symbol));
            } catch (ArithmeticException e) {
                result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return result;
            }
        }
        return result * sign;
    }
}
