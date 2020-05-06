package strings;

import java.util.Arrays;

/**
 * Valid Anagram
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/882/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * Explanation:
 * Convert strings to char arrays and sort them.
 * Compare concatenated strings.
 *
 * Time complexity : O(n * log(n) + m * log(m)). x * log(x) - sort time.
 * Space complexity : O(n + m).
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram app = new ValidAnagram();
        System.out.println(app.isAnagram("anagram", "nagaram")); // true
        System.out.println(app.isAnagram("rat", "car")); // false
    }

    private boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        return String.valueOf(arrS).equals(String.valueOf(arrT));
    }
}
