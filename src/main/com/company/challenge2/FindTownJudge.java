package com.company.challenge2;

/**
 * Find the Town Judge
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
 *
 * In a town, there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 * Note:
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 * Explanation:
 * Create map (array) for trusted numbers with count.
 * Reduce count for each trustier since it can not be the Judge that way.
 * If map contains N - 1 value - it's the answer.
 *
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class FindTownJudge {

    public static void main(String[] args) {
        FindTownJudge app = new FindTownJudge();
        int[][] test = {{1,2}};
        int[][] test2 = {{1,3},{2,3}};
        int[][] test3 = {{1,3},{2,3},{3,1}};
        int[][] test4= {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] test5= {};
        System.out.println(app.findJudge(2, test)); // 2
        System.out.println(app.findJudge(3, test2)); // 3
        System.out.println(app.findJudge(3, test3)); // -1
        System.out.println(app.findJudge(4, test4)); // 3
        System.out.println(app.findJudge(1, test5)); // 1
    }

    private int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N + 1];
        for (int[] ints : trust) {
            trusted[ints[0]]--;
            trusted[ints[1]]++;
        }
        for (int i = 1; i < trusted.length; i++) {
            if (trusted[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
