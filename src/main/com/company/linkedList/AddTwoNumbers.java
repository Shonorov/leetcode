package com.company.linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Add Two Numbers
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 * Explanation:
 * Two pointers for each list.
 * While list not empty and carry != 0 add new ListNode(sum % 10).
 *
 * Time complexity : O(max(m,n)).
 * Space complexity : O(max(m,n)).
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers app = new AddTwoNumbers();
        ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = app.addTwoNumbers(list1, list2);
        assertEquals(result.val, 7);
        assertEquals(result.next.val, 0);
        assertEquals(result.next.next.val, 8);
        assertNull(result.next.next.next);

        ListNode result2 = app.addTwoNumbers(new ListNode(0), new ListNode(0));
        assertEquals(result2.val, 0);
        assertNull(result2.next);

        ListNode list23 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode list13 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result3 = app.addTwoNumbers(list13, list23);
        assertEquals(result3.val, 8);
        assertEquals(result3.next.val, 9);
        assertEquals(result3.next.next.val, 9);
        assertEquals(result3.next.next.next.val, 9);
        assertEquals(result3.next.next.next.next.val, 0);
        assertEquals(result3.next.next.next.next.next.val, 0);
        assertEquals(result3.next.next.next.next.next.next.val, 0);
        assertEquals(result3.next.next.next.next.next.next.next.val, 1);
        assertNull(result3.next.next.next.next.next.next.next.next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbersMy(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode result = new ListNode();
        int memo = 0;
        while (l1 != null || l2 != null || memo != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + memo;
            memo = sum / 10;
            if (root == null) {
                result.val = sum % 10;
                root = result;
            } else {
                result.next = new ListNode(sum % 10);
                result = result.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root;
    }

}
