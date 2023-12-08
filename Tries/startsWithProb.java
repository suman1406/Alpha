package Tries;

public class startsWithProb {

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

    static boolean startsWith(String[] dict, String prefix) {
        root = new TrieNode();
        for (String word : dict)
            insert(word);
        return search(prefix);
    }

    public static void main(String[] args) {
        String[] dict = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String prefix = "geek";
        System.out.println(startsWith(dict, prefix));

        prefix = "geeks";
        System.out.println(startsWith(dict, prefix));
        prefix = "geezer";
        System.out.println(startsWith(dict, prefix));
    }    
}
