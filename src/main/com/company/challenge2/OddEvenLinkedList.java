package com.company.challenge2;

import com.company.linkedList.LinkedListUtils;
import com.company.linkedList.ListNode;

/**
 * Odd Even Linked List
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * Explanation:
 * Traverse list evens while it not null [#]. Save last odd pointer to variable (#).
 * If next even exists save next odd and next even to variables.
 * - start                                    (1) -> [2] -> 3 -> 4
 * - current even next = next even (nullable) (1) -> [2] -> 4 ( 3 -> 4)
 * - next odd next = last odd next            (1) -> [2] -> 4 ( 3 -> 2)
 * - last odd next = next odd                 (1) -> 3 -> [2] -> 4
 * - last odd = next odd                       1 -> (3) -> 2 -> [4]
 * - last even = next even
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList app = new OddEvenLinkedList();
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode test2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode test3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));
        LinkedListUtils.printList(app.oddEvenList(test)); // 1 -> 3 -> 5 -> 2 -> 4 -> NULL
        LinkedListUtils.printList(app.oddEvenList(test2)); // 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> NULL
        LinkedListUtils.printList(app.oddEvenList(test3)); // 1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6 -> NULL
        LinkedListUtils.printList(app.oddEvenList(null)); // 1 -> 3 -> 5 -> 7 -> 2 -> 4 -> 6 -> NULL

    }

    private ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode lastOdd = head;
        ListNode even = head.next;
        while (even != null) {
            ListNode nextEven = even.next != null ? even.next.next : null;
            ListNode nextOdd = even.next;
            if (nextOdd != null) {
                even.next = nextEven;
                nextOdd.next = lastOdd.next;
                lastOdd.next = nextOdd;
                lastOdd = nextOdd;
            }
            even = nextEven;

        }
        return head;
    }
}
