package com.company.linkedList;

import java.util.LinkedList;

import static com.company.linkedList.LinkedListUtils.printList;

/**
 * Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 *
 * Explanation:
 * Find of middle with rabbit and turtle.
 * headOfRest = middleNode.next
 * middleNode.next = null
 * Reverse second list, then merge into original list.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList app = new ReorderList();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        app.reorderList(head1);
        printList(head1); // [1,5,2,4,3]

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        app.reorderList(head2);
        printList(head2); // [1,4,2,3]


        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        app.reorderList(head3);
        printList(head3); // [1,3,2]

        ListNode head4 = new ListNode(1, new ListNode(2));
        app.reorderList(head4);
        printList(head4); // [1,2]

        ListNode head5 = new ListNode(1);
        app.reorderList(head5);
        printList(head5); // [1]
    }

    public void reorderList(ListNode head) {
        ListNode middleNode = findMiddleNode(head);
        ListNode headOfRest = middleNode.next;
        middleNode.next = null;
        headOfRest = reverseList(headOfRest);
        interleaveLists(head, headOfRest);
    }

    public void interleaveLists(ListNode head1, ListNode head2) {
        ListNode ptr = head1;
        while (head2 != null) {        // p    t
            ListNode temp = ptr.next;  // 1 -> 2 -> 3
            ptr.next = head2;          // p            t
            head2 = head2.next;        // 1 -> 5 -> 4  2 -> 3
            ptr.next.next = temp;      //          pt
            ptr = temp;                // 1 -> 5 -> 2 -> 3
        }
    }

    private ListNode reverseListMy(ListNode head) {
        ListNode next = null;
        while (head != null) {
            ListNode mid = head;
            head = head.next;                   //   n     m  h
            mid.next = next;                    // null <- 1  2 - null
            next = mid;                         //        mn  h
        }                                       // null <- 1  2 - null
        return next;
    }

    public ListNode findMiddleNode(ListNode head) {
        ListNode slowPtr;
        ListNode fastPtr;
        slowPtr = fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;   //     p    h  t
            head.next = prev;            //  null <- 1  2 -> null
            prev = head;                 //          p  th
            head = temp;                 //  null <- 1  2 -> null
        }
        return prev;
    }

    public void reorderListStack(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode pointer = head;
        while (pointer.next != null) {
            stack.add(pointer.next);
            pointer = pointer.next;
        }
        pointer = head;
        while (stack.size() >= 2) {
            ListNode reorder = stack.removeLast();
            stack.getLast().next = null;
            pointer.next = reorder;
            reorder.next = stack.getFirst();
            pointer = stack.removeFirst();
        }
    }
}
