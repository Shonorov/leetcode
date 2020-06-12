package com.company.challenge3;

import java.util.*;

/**
 * Insert Delete GetRandom O(1)
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 * Algorithm:
 * To achieve getRandom() in O(1) store all values in a list and get by random index.
 * Map contains values and its index in list.
 * Add to the end of list.
 * Copy last value to the removing index, remove last then.
 * Update map while doing both.
 *
 * Time complexity : O(1).
 * Space complexity : O(n).
 */
public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1)); // true
        System.out.println(randomSet.remove(2)); // false
        System.out.println(randomSet.insert(2)); // true;
        System.out.println(randomSet.getRandom());   // 1 or 2
        System.out.println(randomSet.remove(1)); // true
        System.out.println(randomSet.insert(2)); // false
        System.out.println(randomSet.getRandom());   // 2
    }

    private List<Integer> values;
    private Map<Integer, Integer> positions;
    private static Random random = new Random();

    private RandomizedSet() {
        values = new ArrayList<>();
        positions = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    private boolean insert(int val) {
        if (positions.containsKey(val)) return false;
        positions.put(val, values.size());
        values.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    private boolean remove(int val) {
        if (!positions.containsKey(val)) return false;
        int index = positions.get(val);
        int last = values.get(values.size() - 1);
        values.set(index, last);
        values.remove(values.size() - 1);
        positions.replace(last, index);
        positions.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    private int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
