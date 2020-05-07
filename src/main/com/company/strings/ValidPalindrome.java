package com.company.strings;

/**
 * Valid Palindrome
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * Explanation:
 * ToLowerCase (and replaceAll with regexp) then traverse string from both ends.
 * If not valid character - search next.
 * If valid not the same - return false;
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome app = new ValidPalindrome();
        System.out.println(app.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(app.isPalindrome("race a car")); // false
    }

    private boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while(start < end && !((s.charAt(start)>='a' && s.charAt(start)<='z')
                    || (s.charAt(start)>='0'&&s.charAt(start)<='9'))){
                start++;
            }

            while(start < end && !((s.charAt(end)>='a' && s.charAt(end)<='z')
                    || (s.charAt(end)>='0'&&s.charAt(end)<='9'))){
                end--;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // almost same but slower
    private boolean isPalindrome2(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
