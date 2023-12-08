package Tries;

public class LongestWordWithPrefixes {
    static class Trie {
        Trie[] children;
        boolean isEnd;
        String word;

        Trie() {
            children = new Trie[26];
            isEnd = false;
            word = "";
        }

        void insert(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie();
                }
                curr = curr.children[index];
            }
            curr.isEnd = true;
            curr.word = s;
        }

        String longestWord() {
            String longest = "";
            for (int i = 0; i < 26; i++) {
                if (children[i] != null && children[i].isEnd) {
                    String curr = children[i].longestWord();
                    if (curr.length() > longest.length()) {
                        longest = curr;
                    }
                }
            }
            return word.length() > longest.length() ? word : longest;
        }
    }

    public static String longestWord(String[] words) {
        Trie t = new Trie();
        for (String word : words) {
            t.insert(word);
        }
        return t.longestWord();
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }
}