package com.company.linkedList;

/**
 * Remove Nth Node From End of List
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 *
 * Hint
 * Maintain two pointers and update one with a delay of n steps.
 *
 * Algorithm:
 * Add two pointers. BeforeNth and tail nodes.
 * While list has next, move tail and Nth with N delay.
 * If delay > 0 - remove head.
 * If BeforeNth has next - remove node.
 * Else single node list - return null.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class RemoveNthNodeFromEndList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndList app = new RemoveNthNodeFromEndList();
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode test2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode test3 = new ListNode(1, new ListNode(2));
        ListNode test4 = new ListNode(1);
        ListNode test5 = new ListNode(1, new ListNode(2));
        LinkedListUtils.printList(app.removeNthFromEnd(test, 2)); // 1->2->3->5->NULL
        LinkedListUtils.printList(app.removeNthFromEnd(test2, 3)); // 1->2->4->5->NULL
        LinkedListUtils.printList(app.removeNthFromEnd(test3, 1)); // 1->NULL
        LinkedListUtils.printList(app.removeNthFromEnd(test5, 2)); // 2->NULL
        LinkedListUtils.printList(app.removeNthFromEnd(test4, 1)); // NULL
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeNth = head;
        ListNode tail = head;
        while (tail.next != null) {
            if (--n < 0) {
                beforeNth = beforeNth.next;
            }
            tail = tail.next;
        }
        if (beforeNth.next != null && n > 0) {
            head = beforeNth.next;
        } else if (beforeNth.next != null) {
            beforeNth.next = beforeNth.next.next;
        } else {
            head = null;
        }
        return head;
    }
}
