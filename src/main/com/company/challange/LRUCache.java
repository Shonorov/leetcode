package com.company.challange;

import java.util.*;

/**
 * LRU Cache
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3309/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * LRUCache cache = new LRUCache( 2 );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * Explanation:
 * LinkedHashMap preserves insertion order.
 * Remove and add to the end on get.
 * Remove if exist (overwrite case).
 * If capacity is overflowed find first entry with iterator and remove (LRU).
 * Add new to the end.
 *
 * Time complexity : O(1).
 * Space complexity : O(0).
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); //      [first, last]
        cache.put(1, 1);                   //              [1, null]
        cache.put(2, 2);                   //              [1, 2]
        System.out.println(cache.get(1)); // 1            [2, 1]
        cache.put(3, 3);                   // evicts key 2 [1, 3]
        System.out.println(cache.get(2)); // -1           [1, 3]
        cache.put(4, 4);                   // evicts key 1 [3, 4]
        System.out.println(cache.get(1)); // -1           [3, 4]
        System.out.println(cache.get(3)); // 3            [4, 3]
        System.out.println(cache.get(4)); // 4            [3, 4]
        System.out.println(cache.get(3)); // 3            [4, 3]
        System.out.println("----------------------------");
        LRUCache cache2 = new LRUCache(2); //      [first, last]
        System.out.println(cache2.get(2)); // -1           [null, null]
        cache2.put(2, 6);                  //              [2, null]
        System.out.println(cache2.get(1)); // -1           [2, null]
        cache2.put(1, 5);                  //              [2, 1]
        cache2.put(1, 2);                  //              [2, 1]
        System.out.println(cache2.get(1)); // 2            [2, 1]
        System.out.println(cache2.get(2)); // 6            [1, 2]
        System.out.println("----------------------------");
        LRUCache cache3 = new LRUCache(2); //      [first, last]
        cache3.put(2, 1);                  //              [2, null]
        cache3.put(1, 1);                  //              [2, 1]
        cache3.put(2, 3);                  //              [1, 2]
        cache3.put(4, 1);                  //              [2, 4]
        System.out.println(cache3.get(1)); // -1           [2, 4]
        System.out.println(cache3.get(2)); // 3            [2, 4]

    }

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);

    }

    public int get(int key) {
        System.out.println("Get " + key + " " + cache);
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    private void put(int key, int value) {
        System.out.println("Put " + key + " " + cache);
        cache.remove(key);
        if (cache.size() >= capacity) {
            int firstKey = cache.entrySet().iterator().next().getKey();
            cache.remove(firstKey);
        }
        cache.put(key, value);
    }
}
