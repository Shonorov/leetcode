package com.company.challenge3;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Search II
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example:
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Note:
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 * Hint:
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 * What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not?
 * How about a Trie? If you would like to learn how to implement a basic trie,
 * please work on this problem: Implement Trie (Prefix Tree) first.
 *
 * Algorithm:
 * First create and fill Trie with leafs as letters and not null word if it's the word end node.
 * Perform words search for every letter in matrix.
 * If leaf with that letter exist and word is not empty - word is found.
 * Mark visited letters and reset it back on exit.
 * Search adjacent letters if its available.
 *
 * Time complexity : O(m * n * l * wl). l is words.length and wl is the average of length of words in 'words'
 * Space complexity : O(l * wl).
 */
public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII app = new WordSearchII();
        char[][] test = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(app.findWords(test, words)); // [oath, eat]
    }

    class TrieNode {
        TrieNode[] leafs = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';
                if (current.leafs[index] == null) {
                    current.leafs[index] = new TrieNode();
                }
                current = current.leafs[index];
            }
            current.word = word;
        }
        return root;
    }

    private List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, result);
            }
        }
        return result;
    }

    private void search(char[][] board, int i, int j, TrieNode trie, List<String> result) {
        char letter = board[i][j];
        if (letter == '#' || trie.leafs[letter - 'a'] == null) return;
        trie = trie.leafs[letter - 'a'];
        if (trie.word != null) {
            result.add(trie.word);
            trie.word = null;
        }

        board[i][j] = '#';
        if (i > 0) search(board, i - 1, j, trie, result);
        if (j > 0) search(board, i, j - 1, trie, result);
        if (i < board.length - 1) search(board, i + 1, j, trie, result);
        if (j < board[0].length - 1) search(board, i, j + 1, trie, result);
        board[i][j] = letter;
    }
}
