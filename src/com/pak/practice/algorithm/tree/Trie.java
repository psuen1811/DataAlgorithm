package com.pak.practice.algorithm.tree;

class Trie {
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
    TrieNode root;

    static class TrieNode {
        final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
            this.isEndOfWord = false;
        }
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    void insert(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        // String[] keys = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String [] keys = {"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn",
                "sdaklfj", "asdjf"};

        String[] output = {"Not present in trie", "Present in trie"};
        String[] searchStr = {"abcde", "sdaklfj", "asdjf", "na", "basdn"};
        Trie t = new Trie();
        t.root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            t.insert(keys[i]);

        for( String s : searchStr) {
            if( t.search(s))
                System.out.println("True");
            else
                System.out.println("False");

        }

        /*
        // Search for different keys
        if (t.search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (t.search("these"))
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (t.search("their"))
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (t.search("thaw"))
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

         */
    }

}
