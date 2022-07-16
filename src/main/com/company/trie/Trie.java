package com.company.trie;

/**
 * Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 * Explanation:
 * Trie description here: https://leetcode.com/problems/implement-trie-prefix-tree/solution/
 * Trie node contains array of nodes per letter and mark isEnd meaning there are word ending here.
 * word.charAt(i) - 'a' means 'a' == 0 index 'b' = 'b' - 'a' == 1 index etc.
 * If node for all letters exist - startsWith is true.
 * If node for all letters exist and last node marked as end - contains is true.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        String test = "apple";
        String test2 = "app";
        trie.insert(test);
        System.out.println(trie.search(test)); // true
        System.out.println(trie.search(test2)); // false
        System.out.println(trie.startsWith(test2)); // true
        trie.insert(test2);
        System.out.println(trie.search(test2)); // true
        System.out.println("------------------");
        Trie trie2 = new Trie();
        String test3 = "a";
        trie2.insert(test3);
        System.out.println(trie2.search(test3)); // true
        System.out.println(trie2.startsWith(test3)); // true
        System.out.println("------------------");
        Trie trie3 = new Trie();
        trie3.insert("app");
        trie3.insert("apple");
        trie3.insert("beer");
        trie3.insert("add");
        trie3.insert("jam");
        trie3.insert("rental");
        System.out.println(trie3.search("apps")); // false
        System.out.println(trie3.search("app")); // true
        System.out.println(trie3.search("ad")); // false
        System.out.println(trie3.search("applepie")); // false
        System.out.println(trie3.search("rest")); // false
        System.out.println(trie3.search("jan")); // false
        System.out.println(trie3.search("rent")); // false
        System.out.println(trie3.search("beer")); // true
        System.out.println(trie3.search("jam")); // true
        System.out.println(trie3.startsWith("apps")); // false
        System.out.println(trie3.startsWith("app")); // true
        System.out.println(trie3.startsWith("ad")); // true
        System.out.println(trie3.startsWith("applepie")); // false
        System.out.println(trie3.startsWith("rest")); // false
        System.out.println(trie3.startsWith("jan")); // false
        System.out.println(trie3.startsWith("rent")); // true
        System.out.println(trie3.startsWith("beer")); // true
        System.out.println(trie3.startsWith("jam")); // true
    }

    private Trie[] links;
    private final int charSet = 26;
    private boolean isEnd;

    private Trie() {
        this.links = new Trie[charSet];
        this.isEnd = false;
    }

    private Trie put(char letter, Trie node) {
        if (node.links[letter - 'a'] == null) {
            node.links[letter - 'a'] = new Trie();
        }
        return node.links[letter - 'a'];
    }

    private Trie getTailNode(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.links[word.charAt(i) - 'a'] != null) {
                node = node.links[word.charAt(i) - 'a'];
            } else {
                return null;
            }
        }
        return node;
    }

    private void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            node = put(word.charAt(i), node);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie tail = getTailNode(word);
        return tail != null && tail.isEnd;
    }

    private boolean startsWith(String prefix) {
        Trie tail = getTailNode(prefix);
        return tail != null;
    }
}
