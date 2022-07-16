package com.company.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value and the median is the mean of the two middle values.
 *     For example, for arr = [2,3,4], the median is 3.
 *     For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *     MedianFinder() initializes the MedianFinder object.
 *     void addNum(int num) adds the integer num from the data stream to the data structure.
 *     double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * Example 1:
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Constraints:
 * -105 <= num <= 105
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 *
 * Explanation:
 * Create two priority queues: leftLarge reversed and rightSmall.
 * leftLarge: 1 -> 2 -> (3) | 4 <- 5 :rightSmall
 * leftLarge: 1 -> 2 -> (3) | (4) <- 5 <- 6 :rightSmall
 * If sizes equal add number to the leftLarge (mid for odd count),
 * otherwise add number to the rightSmall (mid-values are in both queues).
 * First add number to opposite queue for sorting.
 *;
 * Time complexity : O(log(n)). - add
 * Time complexity : O(1). - find
 * Space complexity : O(n). add/find
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder app = new MedianFinder();
        app.addNum(1);
        app.addNum(2);
        assertEquals(1.5, app.findMedian(), 0);
        app.addNum(3);
        assertEquals(2.0, app.findMedian(), 0);
    }
}

class MedianFinder {

    private final PriorityQueue<Integer> leftLarge;
    private final PriorityQueue<Integer> rightSmall;

    public MedianFinder() {
        leftLarge = new PriorityQueue<>(Comparator.reverseOrder());
        rightSmall = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftLarge.size() == rightSmall.size()) {
            rightSmall.offer(num);
            leftLarge.offer(rightSmall.poll());
        } else {
            leftLarge.offer(num);
            rightSmall.offer(leftLarge.poll());
        }
    }

    public double findMedian() {
        return leftLarge.size() == rightSmall.size() ? ((leftLarge.peek() + rightSmall.peek()) / 2.0) : leftLarge.peek();
    }
}
