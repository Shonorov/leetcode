package com.company.other;

import java.util.ArrayList;;
import java.util.List;

/**
 * Pascal's Triangle
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= numRows <= 30
 *
 * Explanation:
 * Loop through numRows from 2, add sublist nj result.
 * Edge list elements are always 1, other.get(j) = previous.get(j) + previous.get(j - 1).
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle app = new PascalsTriangle();
        System.out.println(app.generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]];
        System.out.println(app.generate(1)); // [[1]]
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> previous = result.get(result.size() - 1);
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    current.add(1);
                } else {
                    current.add(previous.get(j) + previous.get(j - 1));
                }
            }
            result.add(current);
        }
        return result;
    }
}
