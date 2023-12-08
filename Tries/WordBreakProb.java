package Tries;

public class WordBreakProb {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    static TrieNode root;

    static void insert(String key) {
        TrieNode pCrawl = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode pCrawl = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    static boolean wordBreak(String s, String[] dict) {
        root = new TrieNode();
        for (String word : dict)
            insert(word);
        int size = s.length();
        if (size == 0)
            return true;
        for (int i = 1; i <= size; i++) {
            if (search(s.substring(0, i)) && wordBreak(s.substring(i, size), dict))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        String[] dict = {"apple", "pen"};
        System.out.println(wordBreak(s, dict));

        s = "catsandog";

        String[] dict2 = {"cats", "dog", "sand", "and", "cat"};

        System.out.println(wordBreak(s, dict2));
    }
}
