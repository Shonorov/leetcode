package com.company.challenge3;

import java.util.*;

/**
 * Two City Scheduling
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
 *
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 * Note:
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 * Algorithm:
 * Get sum of all trips to city A.
 * Create array of differences and sort it descending.
 * Refund half of differences from sum.
 *
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class TwoCityScheduling {

    public static void main(String[] args) {
        TwoCityScheduling app = new TwoCityScheduling();
        int[][] test = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(app.twoCitySchedCost(test)); // 110
    }

    // sort takes O(n * log(n))
    private int twoCitySchedCostSorting(int[][] costs) {
        Comparator<int[]> comparator = Comparator.comparingInt(o -> (o[0] - o[1]));
        Arrays.sort(costs, comparator);
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
            sum += costs[costs.length / 2 + i][1];
        }
        return sum;
    }

    private int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] difference = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i][0];
            difference[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(difference);
        for (int i = 0; i < costs.length / 2; i++) {
            sum += difference[i];
        }
        return sum;
    }
}
