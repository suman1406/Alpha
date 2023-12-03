package Queue;
import java.util.*;

public class QueueQA {
    public void printNonRepeating(String str) {
        Queue<Character> q = new LinkedList<Character>();
        int[] charCount = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            charCount[ch - 'a']++;

            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1) {
                    q.remove();
                } else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }

            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            }
        }
    }

    //Interleave 2 halves of a Queue (even length)
    public void interleave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            System.out.println("Queue size is not even");
            return;
        }

        Stack<Integer> s = new Stack<Integer>();
        int halfSize = q.size() / 2;

        for (int i = 0; i < halfSize; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        for (int i = 0; i < halfSize; i++) {
            q.add(q.remove());
        }

        for (int i = 0; i < halfSize; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
            q.add(q.remove());
        }
    }

    // Queue reversal
    public void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String args[]) {
        QueueQA q = new QueueQA();
        q.printNonRepeating("aabc");

        Queue<Integer> q1 = new LinkedList<Integer>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        q.interleave(q1);
        System.out.println(q1);

        Queue<Integer> q2 = new LinkedList<Integer>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q.reverse(q2);
        System.out.println(q2);
    }
}
