package Tries;

public class UniqueSubstrings {

    static class Trie {
        Trie[] children;
        int count;

        Trie() {
            children = new Trie[26];
            count = 0;
        }

        void insert(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie();
                }
                curr = curr.children[index];
                curr.count++;
            }
        }

        int countNodes() {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (children[i] != null) {
                    count += children[i].countNodes();
                }
            }
            return count + 1;
        }
    }

    public static int uniqueSubstrings(String s) {
        Trie t = new Trie();
        for (int i = 0; i < s.length(); i++) {
            t.insert(s.substring(i));
        }
        return t.countNodes();
    }

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(uniqueSubstrings(s));
    }    
}
