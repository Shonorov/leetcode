package com.company.challenge3;

import java.util.*;

/**
 * Reconstruct Itinerary
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 *
 * Example 1:
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * Example 2:
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 * Algorithm:
 * Create Map<from, Queue<to>>. Add start location to the result list.
 * Recursively visit all Map keys until value queues not empty.
 * Add visited keys to the start of result.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        ReconstructItinerary app = new ReconstructItinerary();
        List<List<String>> test = new ArrayList<>();
        test.add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
        test.add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
        test.add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
        test.add(new ArrayList<>(Arrays.asList("LHR", "SFO")));
        List<List<String>> test2 = new ArrayList<>();
        test2.add(new ArrayList<>(Arrays.asList("JFK","SFO")));
        test2.add(new ArrayList<>(Arrays.asList("JFK","ATL")));
        test2.add(new ArrayList<>(Arrays.asList("SFO","ATL")));
        test2.add(new ArrayList<>(Arrays.asList("ATL","JFK")));
        test2.add(new ArrayList<>(Arrays.asList("ATL","SFO")));
        System.out.println(app.findItinerary(test)); // ["JFK", "MUC", "LHR", "SFO", "SJC"]
        System.out.println(app.findItinerary(test2)); // ["JFK","ATL","JFK","SFO","ATL","SFO"]
    }


    private List<String> findItinerary(List<List<String>> tickets) {
        fromToMap = new HashMap<>();
        result = new LinkedList<>();
        for (List<String> ticket : tickets) {
            fromToMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return result;
    }

    private Map<String, PriorityQueue<String>> fromToMap;
    private List<String> result;

    private void visit(String from) {
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            visit(fromToMap.get(from).poll());
        }
        result.add(0, from);
    }
}
