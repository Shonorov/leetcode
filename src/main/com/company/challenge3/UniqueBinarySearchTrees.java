package com.company.challenge3;

/**
 * Unique Binary Search Trees
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Algorithm:
 * Write to the dynamic programming array count of unique subtrees for every element count.
 * For every element count step pick every of nodes as root and sum all subtree count for each.
 * Subtree count for each root is leftSubtreeCount * rightSubtreeCount.
 *
 * Visualisation for 4 node example:
 * tree count = [ 1 1 2 5 0 ]
 * root = 1 | 0 left nodes count * 3 right nodes count | 0 + 1 * 5 = 5
 * tree count = [ 1 1 2 5 5 ]
 * root = 2 | 1 left nodes count * 2 right nodes count | 5 + 1 * 2 = 7
 * tree count = [ 1 1 2 5 7 ]
 * root = 3 | 2 left nodes count * 1 right nodes count | 7 + 2 * 1 = 9
 * tree count = [ 1 1 2 5 9 ]
 * root = 4 | 3 left nodes count * 0 right nodes count | 9 + 5 * 1 = 14
 * tree count = [ 1 1 2 5 14 ]
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees app = new UniqueBinarySearchTrees();
        System.out.println(app.numTrees(3)); // 5
        System.out.println(app.numTrees(4)); // 14
    }

    private int numTrees(int n) {
        int[] trees = new int[n + 1];
        trees[0] = 1;
        trees[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                trees[i] += trees[root - 1] * trees[i - root];
            }
        }
        return trees[n];
    }

    // Skip symmetric calculations by doubling first half of root results
    private int numTrees2(int n) {
        int[] trees = new int[n + 1];
        trees[0] = 1;
        trees[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                trees[i] += 2 * trees[left++] * trees[right--];
            }
            if (left == right) {
                trees[i] += trees[left] * trees[right];
            }
        }
        return trees[n];
    }
}
