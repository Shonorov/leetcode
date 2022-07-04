package com.company.backtracking;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Letter Combinations of a Phone Number
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/793/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 * Explanation:
 * For each digit remove from the queue strings with length == digit index in given string.
 * Append all letters in current digit mapping and add result to the queue.
 *
 * Time complexity : O(4 ^ n).
 * Space complexity : O(4 ^ n).
 */
public class LetterCombinationsOfPhoneNumber {

    private final String[][] buttons = new String[][]{
            null, null,
            new String[]{"a", "b", "c"},
            new String[]{"d", "e", "f"},
            new String[]{"g", "h", "i"},
            new String[]{"j", "k", "l"},
            new String[]{"m", "n", "o"},
            new String[]{"p", "q", "r", "s"},
            new String[]{"t", "u", "v"},
            new String[]{"w", "x", "y", "z"}};

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber app = new LetterCombinationsOfPhoneNumber();
        assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"), app.letterCombinations("23"));
        assertEquals(List.of("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"), app.letterCombinations("234"));
        assertEquals(List.of(), app.letterCombinations(""));
        assertEquals(List.of("a","b","c"), app.letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String[] letters = buttons[Character.getNumericValue(digits.charAt(i))];
            while (result.peek() != null && result.peek().length() == i) {
                String current = result.removeFirst();
                for (String letter : letters) {
                    result.add(current + letter);
                }
            }
        }
        return result;
    }
}
