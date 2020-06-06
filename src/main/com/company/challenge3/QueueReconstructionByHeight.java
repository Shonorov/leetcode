package com.company.challenge3;

import com.company.array.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Queue Reconstruction by Height
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
 *
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people
 * in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * Hint #1
 * What can you say about the position of the shortest person?
 * If the position of the shortest person is i, how many people would be in front of the shortest person?
 * Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
 *
 * Algorithm:
 * Sort people descending height - ascending number of people before count.
 * Insert into the list at the exact index according to people before count.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class QueueReconstructionByHeight {

    public static void main(String[] args) {

        QueueReconstructionByHeight app = new QueueReconstructionByHeight();
        int[][] test = {{7,1},{4,4},{7,0},{5,0},{6,1},{5,2}};
        int[][] test2 = {};
        int[][] test3 = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        ArrayUtils.printTwoDimArray(app.reconstructQueue(test)); // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        ArrayUtils.printTwoDimArray(app.reconstructQueue(test2)); // []
        ArrayUtils.printTwoDimArray(app.reconstructQueue(test3)); // [[6,0],[1,1],[8,0],[7,1],[9,0],[2,4],[0,6],[2,5],[3,4],[7,3]]
    }

    private int[][] reconstructQueue2(int[][] people) {
        if (people.length == 0) return people;
        Comparator<int[]> cmp = Comparator.comparingInt(o -> o[0] * 10 + o[1]);
        Arrays.sort(people, cmp);
        int[][] result = new int[people.length][2];
        Arrays.fill(result, new int[]{-1, -1});
        result[people[0][1]] = people[0];
        for (int i = 1; i < people.length; i++) {
            int count = people[i][1];
            for (int j = 0; j < result.length; j++) {
                if (result[j][0] == -1 && count == 0) {
                    result[j] = people[i];
                    break;
                }
                if (result[j][0] == -1 || result[j][0] >= people[i][0]) count--;
            }
        }
        return result;
    }

    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();
        for(int[] p : people){
            result.add(p[1], p);
        }
        return result.toArray(new int[people.length][2]);
    }
}
