package Tries;

public class TrieCode {
    static class Node {
        Node children[] = new Node[26];
        boolean isEndOfWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String key) {
        Node temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (temp.children[index] == null) {
                temp.children[index] = new Node();
            }

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    public static boolean search(String key) {
        Node temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (temp.children[index] == null) {
                return false;
            }

            temp = temp.children[index];
        }

        return temp != null && temp.isEndOfWord;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        for (String key : keys) {
            insert(key);
        }

        System.out.println(search("the"));
        System.out.println(search("these"));
        System.out.println(search("their"));
        System.out.println(search("thaw"));
    }
}
