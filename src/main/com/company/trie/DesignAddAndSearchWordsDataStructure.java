package com.company.trie;

import static org.junit.Assert.assertEquals;

/**
 * Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 *     WordDictionary() Initializes the object.
 *     void addWord(word) Adds word to the data structure, it can be matched later.
 *     bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 *     word may contain dots '.' where dots can be matched with any letter.
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 * Constraints:
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 3 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 *
 * Explanation:
 * Create TrieNode tree on add. Links index is [char - 'a'].
 * For wildcard search in all children recursively.
 * Word found if all leaves present and last one isEnd.
 *
 * Time complexity : O(n).
 * Space complexity : O(n).
 */
public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assertEquals(false, wordDictionary.search("pad"));
        assertEquals(true, wordDictionary.search("bad"));
        assertEquals(true, wordDictionary.search(".ad"));
        assertEquals(true, wordDictionary.search("b.."));
        assertEquals(true, wordDictionary.search("..."));
        assertEquals(false, wordDictionary.search("b"));
        assertEquals(false, wordDictionary.search("."));
        assertEquals(false, wordDictionary.search(""));
    }
}

class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (current.links[index] == null) {
                current.links[index] = new TrieNode();
            }
            current = current.links[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return subSearch(word.toCharArray(), 0, root);
    }

    private boolean subSearch(char[] word, int start, TrieNode subNode) {
        if (subNode == null) return false;
        TrieNode current = subNode;
        for (int i = start; i < word.length; i++) {
            char letter = word[i];
            if ('.' == letter) {
                for (TrieNode node : current.links) {
                    if (subSearch(word, i + 1, node)) {
                        return true;
                    }
                }
                return false;
            }
            int index = letter - 'a';
            if (current.links[index] == null) return false;
            current = current.links[index];
        }
        return current.isEnd;
    }
}
