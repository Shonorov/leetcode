package com.company.linkedList;

import static com.company.linkedList.LinkedListUtils.printList;

/**
 * Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * EExample 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 * Explanation:
 * Pair up k lists and merge each pair.
 * Repeat this procedure until we get the final sorted linked list.
 * See MergeKSortedLists.png
 * Can use binary list selection.
 *
 * Time complexity : O(n * log(k)). k - lists.length
 * Space complexity : O(1).
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists app = new MergeKSortedLists();
        ListNode[] nodes1 = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))};
        printList(app.mergeKLists(nodes1)); // 1->1->2->3->4->4->5->6
        printList(app.mergeKLists(new ListNode[0])); // null
        printList(app.mergeKLists(new ListNode[]{null})); // null
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i < lists.length - interval; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode result = new ListNode(-1);
        ListNode pointer = result;

        ListNode copy1 = list1;
        ListNode copy2 = list2;
        while (copy1 != null && copy2 != null) {
            if (copy1.val <= copy2.val) {
                pointer.next = copy1;
                copy1 = copy1.next;
            } else {
                pointer.next = copy2;
                copy2 = copy2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = copy1 != null ? copy1 : copy2;
        return result.next;
    }

    public ListNode mergeKListsNK(ListNode[] lists) {
        ListNode root = lowest(lists);
        ListNode end = root;
        while (end != null) {
            end.next = lowest(lists);
            end = end.next;
        }
        return root;
    }

    private ListNode lowest(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val <= min) {
                min = lists[i].val;
                index = i;
            }
        }
        ListNode result = null;
        if (index >= 0) {
            result = lists[index];
            lists[index] = lists[index].next;
            result.next = null;
        }
        return result;
    }
}
