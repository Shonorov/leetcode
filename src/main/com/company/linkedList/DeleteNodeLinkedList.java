package com.company.linkedList;

/**
 * Delete Node in a Linked List
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 * Note:
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * Explanation:
 * Replace current value and next with next node's value and next.
 *
 * Time complexity : O(1).
 * Space complexity : O(1).
 */
public class DeleteNodeLinkedList {

    static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
       ListNode(int x, ListNode node) { val = x; next = node;}
    }

    public static void main(String[] args) {
        DeleteNodeLinkedList app = new DeleteNodeLinkedList();
        ListNode node4 = new ListNode(9);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode head = new ListNode(4, node2);
        app.deleteNode(node2);
        System.out.println(head.next.val); // 1
        app.deleteNode(node2);
        System.out.println(head.next.val); // 9
    }

    private void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
