package com.company.linkedList;

/**
 * Reverse Linked List
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
 *
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Algorithm:
 * Three pointers current, previous and temp.
 * Temp is next current's.
 * Direct current to previous.
 * Next previous is current.
 * Current is temp.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList app = new ReverseLinkedList();
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode test2 = new ListNode(1);
        ListNode test3 = null;
        LinkedListUtils.printList(app.reverseList(test)); // 5->4->3->2->1->NULL
        LinkedListUtils.printList(app.reverseList(test2)); // 1->NULL
        LinkedListUtils.printList(app.reverseList(test3)); // NULL
    }

    // 1->2->3->4->5->NULL        (previous = NULL, current = 1)
    // NULL<-1  2->3->4->5->NULL  (previous = 1, current = 2)
    // NULL<-1<-2  3->4->5->NULL  (previous = 2, current = 3)
    // NULL<-1<-2<-3  4->5->NULL  (previous = 3, current = 4)
    // NULL<-1<-2<-3<-4  5->NULL  (previous = 4, current = 5)
    // NULL<-1<-2<-3<-4<-5        (return current = 5)
    private ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextCurrent = current.next;
            current.next = previous;
            previous = current;
            current = nextCurrent;
        }
        return previous;
    }

    // 1->2->3->4->5->NULL          (head = 4, previous = 5) (head != null && head.next != null)
    // 1->2->3->4->NULL 5->4->NULL  (head = 3, previous = 5)
    // 1->2->3->NULL 5->4->3->NULL  (head = 2, previous = 5)
    // 1->2->NULL 5->4->3->2->NULL  (head = 1, previous = 5)
    // 1->NULL 5->4->3->2->1->NULL  (return previous = 5)
    private ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode previous = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return previous;
    }

}
