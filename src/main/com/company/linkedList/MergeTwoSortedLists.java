package com.company.linkedList;

/**
 * Merge Two Sorted Lists
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
 *
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Algorithm:
 * Pick result head of lowest first element. Set result list current element = head.
 * While l1 != null and l2 != null append lowest element to current.next.
 * Add not null of two l1 and l2 to the result end;
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists app = new MergeTwoSortedLists();
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode test2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        LinkedListUtils.printList(app.mergeTwoLists(test, test2)); // 1->1->2->3->4->4->NULL
        LinkedListUtils.printList(app.mergeTwoLists(null, null)); // NULL
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result;
        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return result;
    }
}
