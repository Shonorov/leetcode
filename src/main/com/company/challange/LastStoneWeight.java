package com.company.challange;

import java.util.*;

/**
 * Last Stone Weight
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
 *
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.
 * The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 *
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 * Note:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 * Hint:
 * Simulate the process. We can do it with a heap, or by sorting some list of stones every time we take a turn.
 *
 * Explanation:
 * Copt to the autosorting structure.
 * Poll two stone while size > 1 and calculate new.
 *
 * Time complexity : O(n * log(n)).
 * Space complexity : O(n).
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight app = new LastStoneWeight();
        int[] test = {2,7,4,1,8,1};
        System.out.println(app.lastStoneWeight(test)); // 1
        System.out.println(app.lastStoneWeightPQ(test)); // 1
    }

    private int lastStoneWeight(int[] stones) {
        List<Integer> heap = new ArrayList<Integer>() {{ for (int i : stones) add(i); }};
        while (heap.size() > 1) {
            heap.sort(Collections.reverseOrder());
            int a = heap.remove(0);
            int b = heap.remove(0);
            if (a != b) {
               heap.add(a - b);
            }

        }
        return heap.size() != 0 ? heap.get(0) : 0;
    }

    // Somehow faster but the same
    private int lastStoneWeightPQ(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            if (a != b) {
                pq.add(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}
