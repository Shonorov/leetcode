package com.company.trie;

public class TrieNode {

    public TrieNode[] links;
    public final int charSet = 26;
    public boolean isEnd;

    TrieNode() {
        this.links = new TrieNode[charSet];
        this.isEnd = false;
    }
}
