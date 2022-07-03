package com.company.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Intersection of Two Linked Lists
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/785/
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 * Constraints:
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 *
 * Explanation:
 * Add two pointers and while (nodeA != nodeB) iterate by lists.
 * On a first iteration move nodeA to headB and nodeB to HeadA and continue so on.
 * Intersection will be found on a second loop, if no intersection exit when nodeA == nodeB == null.
 *
 * Time complexity : O(m + n).
 * Space complexity : O(1).
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists app = new IntersectionOfTwoLinkedLists();

        ListNode expected1 = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode root1 = new ListNode(4, new ListNode(1, expected1));
        ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(1, expected1)));
        assertEquals(app.getIntersectionNode(root1, root2), expected1);

        ListNode expected2 = new ListNode(2, new ListNode(4));
        ListNode root12 = new ListNode(1, new ListNode(9, new ListNode(1, expected2)));
        ListNode root22 = new ListNode(3, expected2);
        assertEquals(app.getIntersectionNode(root12, root22), expected2);

        ListNode root13 = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode root23 = new ListNode(1, new ListNode(5));
        assertNull(app.getIntersectionNode(root13, root23));

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public ListNode getIntersectionNodeMy(ListNode headA, ListNode headB) {
        Deque<ListNode> stackA = new ArrayDeque<>();
        Deque<ListNode> stackB = new ArrayDeque<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                stackA.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                stackB.add(headB);
                headB = headB.next;
            }
        }
        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pollLast();
            ListNode nodeB = stackB.pollLast();
            if (nodeA.equals(nodeB)) {
                result = nodeA;
            } else {
               return result;
            }
        }
        return result;
    }
}
