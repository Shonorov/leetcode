package com.company.linkedList;

/**
 * Palindrome Linked List
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * Algorithm:
 * Create slow and fast pointers and traverse list to the middle.
 * While doing so reverse the list before slow pointer.
 * Find the start head points from the center and check if they are the same.
 *
 * Time complexity : O(n).
 * Space complexity : O(1).
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        PalindromeLinkedList app = new PalindromeLinkedList();
        ListNode test = new ListNode(1, new ListNode(2));
        ListNode test2 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode test3 = new ListNode(1);
        ListNode test4 = new ListNode(1, new ListNode(0, new ListNode(0)));
        ListNode test5 = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(app.isPalindrome(test)); // false
        System.out.println(app.isPalindrome(test2)); // true
        System.out.println(app.isPalindrome(null)); // true
        System.out.println(app.isPalindrome(test3)); // true
        System.out.println(app.isPalindrome(test4)); // false
        System.out.println(app.isPalindrome(test5)); // true
    }

    private ListNode current;

    private boolean isPalindrome2(ListNode head) {
        current = head;
        return check(head);
    }

    public boolean check(ListNode node){
        if (node == null) return true;
        boolean isPalindrome = check(node.next);
        boolean isEqual = current.val == node.val;
        current = current.next;
        return isPalindrome && isEqual;
    }

    private boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;

        //  Reverse the first half
        ListNode prevSlowNode = null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode!=null && fastNode.next !=null){
            fastNode = fastNode.next.next;                                      //Move fast pointer
            //Reverse
            ListNode nextSlowNode = slowNode.next;                              //Store next node in a variable
            slowNode.next = prevSlowNode;                                       //Point current node to prev node
            prevSlowNode = slowNode;                                            //Move prev node to next (curr) node
            slowNode = nextSlowNode;                                            //Move curr node to next node
        }

        //  Find the pointers to the two halves
        ListNode firstHalfPointer = prevSlowNode;                               //Point to prevSlowNode, like like 4 in [2,4,5,7] or [2,4,5,7,8]
        ListNode secondHalfPointer = null;
        if (fastNode == null) {                                                 //List is of even length, like [2,4,5,7]
            secondHalfPointer = slowNode;                                       //Point to slowNode, like 5 in [2,4,5,7]
        } else if (fastNode.next == null) {                                     //List is of odd length, like [2,4,5,7,8]
            secondHalfPointer = slowNode.next;                                  //Point to slowNode.next, like 7 in [2,4,5,7,8]
        }

        //  Compare the two halves
        while(firstHalfPointer!=null && secondHalfPointer!=null){
            if(firstHalfPointer.val != secondHalfPointer.val){
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
        return true;
    }
}
