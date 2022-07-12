package com.company.trees;

public class PerfectTreeNode {
    public int val;
    public PerfectTreeNode next;
    public PerfectTreeNode left;
    public PerfectTreeNode right;

    public PerfectTreeNode(int val) {
        this.val = val;
    }

    public PerfectTreeNode(int val, PerfectTreeNode left, PerfectTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return (left != null ? String.valueOf(left.val) : "NULL") +
                " <- " + val + " -> " +
                (right != null ? String.valueOf(right.val) : "NULL") +
                " Next: " + (next != null ? next.val : "NULL");
    }
}
