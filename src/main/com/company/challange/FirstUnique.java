package com.company.challange;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * First Unique Number
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/
 *
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 *
 * Implement the FirstUnique class:
 *     FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 *     int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
 *     void add(int value) insert value to the queue.
 *
 * Constraints:
 *     1 <= nums.length <= 10^5
 *     1 <= nums[i] <= 10^8
 *     1 <= value <= 10^8
 *     At most 50000 calls will be made to showFirstUnique and add.
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
 * [[[2,3,5]],[],[5],[],[2],[],[3],[]]
 * Output:
 * [null,2,null,2,null,3,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([2,3,5]);
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(5);            // the queue is now [2,3,5,5]
 * firstUnique.showFirstUnique(); // return 2
 * firstUnique.add(2);            // the queue is now [2,3,5,5,2]
 * firstUnique.showFirstUnique(); // return 3
 * firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
 * [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
 * Output:
 * [null,-1,null,null,null,null,null,17]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
 * firstUnique.showFirstUnique(); // return -1
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
 * firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
 * firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
 * firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
 * firstUnique.showFirstUnique(); // return 17
 *
 * Input:
 * ["FirstUnique","showFirstUnique","add","showFirstUnique"]
 * [[[809]],[],[809],[]]
 * Output:
 * [null,809,null,-1]
 *
 * Explanation:
 * FirstUnique firstUnique = new FirstUnique([809]);
 * firstUnique.showFirstUnique(); // return 809
 * firstUnique.add(809);          // the queue is now [809,809]
 * firstUnique.showFirstUnique(); // return -1
 *
 * Hint: Use doubly Linked list with hashmap of pointers to linked list nodes. add unique number to the linked list.
 *       When add is called check if the added number is unique then it have to be added to the linked list and if it is repeated remove it from the linked list if exists.
 *       When showFirstUnique is called retrieve the head of the linked list.
 * Hint: Use queue and check that first element of the queue is always unique.
 * Hint: Use set or heap to make running time of each function O(logn).
 *
 * Algorithm:
 * Store queue items in Set. Store unique items in LinkedHashSet (!important for search performance).
 * If queue set contains item - remove unique, otherwise add.
 * Return first element of uniques.
 *
 * Time complexity : O(m log(m)). Set search is logarithmic.
 * Space complexity : O(n). n - unique elements.
 */
public class FirstUnique {

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
        System.out.println(firstUnique.showFirstUnique()); // 2
        firstUnique.add(5);                                // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // 2
        firstUnique.add(2);                                // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // 3
        firstUnique.add(3);                                // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // -1
        System.out.println("---------------------------");
        FirstUnique firstUnique2 = new FirstUnique(new int[]{7,7,7,7,7,7});
        System.out.println(firstUnique2.showFirstUnique()); // return -1
        firstUnique2.add(7);                                // the queue is now [7,7,7,7,7,7,7]
        firstUnique2.add(3);                                // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique2.add(3);                                // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique2.add(7);                                // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique2.add(17);                               // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique2.showFirstUnique()); // return 17
        System.out.println("---------------------------");
        FirstUnique firstUnique3 = new FirstUnique(new int[]{809});
        System.out.println(firstUnique3.showFirstUnique()); // return 809
        firstUnique3.add(809);                              // the queue is now [809,809]
        System.out.println(firstUnique3.showFirstUnique()); // return -1
    }

    private Set<Integer> queue = new HashSet<>();
    private Set<Integer> unique = new LinkedHashSet<>();

    private FirstUnique(int[] nums) {
        for (int num : nums) {
          add(num);
        }
    }

    private int showFirstUnique() {
        return unique.size() > 0 ? unique.iterator().next() : -1;
    }

    public void add(int value) {
        if (queue.contains(value)) {
            unique.remove(value);
        } else {
            queue.add(value);
            unique.add(value);
        }
    }
}
