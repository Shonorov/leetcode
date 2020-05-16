package com.company.linkedList;

public class LinkedListUtils {

    public static void printList(ListNode node) {
        if (node != null) {
            System.out.print(node.val + " -> ");
            if (node.next != null) {
                printList(node.next);
            } else {
                System.out.println("NULL");
            }
        } else {
            System.out.println("NULL");
        }
    }
}
