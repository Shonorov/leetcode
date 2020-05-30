package com.company.challenge2;

import com.company.array.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * K Closest Points to Origin
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * Algorithm:
 * Create priority Queue with K length sorted by distance.
 * Fill queue with first K points.
 * Get last element distance as max.
 * At every step compare current point distance with max and replace last element (max distance) with current if it is less than max.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin app = new KClosestPointsToOrigin();
        int[][] test = {{1,3},{-2,2}};
        int[][] test2 = {{3,3},{5,-1},{-2,4}};
        int[][] test3 = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
        ArrayUtils.printTwoDimArray(app.kClosest(test, 1)); // [[-2,2]]
        ArrayUtils.printTwoDimArray(app.kClosest(test2, 2)); // [[3,3],[-2,4]]
        ArrayUtils.printTwoDimArray(app.kClosest(test3, 5)); // [[2,31],[-27,-38],[-55,-39],[-57,-67],[34,-84]]
    }

    private int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(K, (o1, o2) -> distance(o2) - distance(o1));
        for (int i = 0; i < K; i++) {
            minHeap.add(points[i]);
        }
        int max = distance(minHeap.peek());
        for (int i = K; i < points.length; i++) {
            int distance = distance(points[i]);
            if (distance < max) {
                minHeap.poll();
                minHeap.add(points[i]);
                max = distance(minHeap.peek());
            }
        }
        return minHeap.toArray(new int[0][0]);
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private int[][] kClosest2(int[][] points, int K) {
        Map<Integer, Double> distances = new LinkedHashMap<>();
        for (int i = 0; i < points.length; i++) {
            double distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            distances.put(i, distance);
        }
        distances = distances.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int[][] result = new int[K][];
        Iterator<Integer> iterator = distances.keySet().iterator();
        for (int i = 0; i < K; i++) {
            result[i] = points[iterator.next()];
        }
        return result;
    }
}
