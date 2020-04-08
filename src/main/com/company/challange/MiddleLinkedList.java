package com.company.challange;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Middle of the Linked List
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * The number of nodes in the given list will be between 1 and 100.
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Explanation:
 * Traverse linked list with two pointers: one twice faster another.
 * When fast hits the end slow is the middle one.
 *
 * Time complexity : O(n / 2).
 * Space complexity : O(0).
 */

public class MiddleLinkedList {

    public static void main(String[] args) {
        MiddleLinkedList middleLinkedList = new MiddleLinkedList();
        int[] test = {1, 2, 3, 4, 5};
        int[] test2 = {1, 2, 3, 4, 5, 6};
        ListNode head = middleLinkedList.fillList(test);
        ListNode head2 = middleLinkedList.fillList(test2);
        System.out.println(middleLinkedList.middleNode(head).val); //3
        System.out.println(middleLinkedList.middleNode(head2).val); //4
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast.next != null) {
                slow = slow.next;
            }
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        return slow;
    }

    private ListNode fillList(int[] values) {
        ListNode previous = new ListNode(values[0]);
        ListNode head = previous;
        for (int i = 1; i < values.length; i++) {
            ListNode next = new ListNode(values[i]);
            previous.next = next;
            previous = next;
        }
        return head;
    }
}
