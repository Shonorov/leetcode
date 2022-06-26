package com.company.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 *
 * Example 2:
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 *
 * Example 3:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * Constraints:
 * 1 <= n <= 104
 *
 * Explanation:
 * First check 15 case, then 3 and 5, otherwise parse toString().
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz app = new FizzBuzz();
        System.out.println(app.fizzBuzz(3)); // ["1","2","Fizz"]
        System.out.println(app.fizzBuzz(5)); // ["1","2","Fizz","4","Buzz"]
        System.out.println(app.fizzBuzz(15)); // ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isDivFive = i % 5 == 0;
            boolean isDivThree = i % 3 == 0;
            if (isDivFive && isDivThree) {
                result.add("FizzBuzz");
            } else if (isDivFive) {
                result.add("Buzz");
            } else if (isDivThree) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
