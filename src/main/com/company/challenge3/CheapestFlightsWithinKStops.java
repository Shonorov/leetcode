package com.company.challenge3;

import java.util.Arrays;

/**
 * Cheapest Flights Within K Stops
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
 *
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 *
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 * Constraints:
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 *
 * Algorithm:
 * Create cost array, where src cost is zero and other MAX_VALUES.
 * Run through all graph edges K times (max stops). Skip unreached nodes (flyCosts[from] == Integer.MAX_VALUE).
 * Write to the temp array lowest price from current step and previous steps + current price.
 * Update cost array every stop and return flyCosts[dst] if it was changed.
 *
 * flyCosts for each step example 1:
 * [ 0 100 500 ]
 * [ 0 100 200 ]
 *
 * Time complexity : O(m * K). m - edges count.
 * Space complexity : O(n).
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops app = new CheapestFlightsWithinKStops();
        int[][] test = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(app.findCheapestPrice(3, test, 0, 2, 1)); // 200
        System.out.println(app.findCheapestPrice(3, test, 0, 2, 0)); // 500
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] flyCosts = new int[n];
        Arrays.fill(flyCosts, Integer.MAX_VALUE);
        flyCosts[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(flyCosts, n);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (flyCosts[from] == Integer.MAX_VALUE) continue; // no cost == node is unreached yet
                temp[to] = Math.min(temp[to], flyCosts[from] + price);
            }
            flyCosts = temp;
        }
        return flyCosts[dst] == Integer.MAX_VALUE ? -1 : flyCosts[dst];
    }
}
