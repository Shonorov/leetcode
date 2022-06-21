package com.company.linkedList;

/**
 * Linked List Cycle
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 *
 * Algorithm:
 * Turtle and Rabbit. Rabbit moves twice faster and will meet turtle if there is cycle in linked list.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        LinkedListCycle app = new LinkedListCycle();
        ListNode node4 = new ListNode(-4);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        node4.next = node2;
        ListNode head = new ListNode(3, node2);
        System.out.println(app.hasCycle(head)); // true

        ListNode node22 = new ListNode(2);
        ListNode head2 = new ListNode(1, node22);
        node22.next = head2;
        System.out.println(app.hasCycle(head2)); // true

        ListNode head3 = new ListNode(1);
        System.out.println(app.hasCycle(head3)); // false

        ListNode node43 = new ListNode(4);
        ListNode node42 = new ListNode(3, node43);
        ListNode node41 = new ListNode(2, node42);
        ListNode head4 = new ListNode(1, node41);
        System.out.println(app.hasCycle(head4)); // false
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
