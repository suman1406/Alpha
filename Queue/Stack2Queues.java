package Queue;

import java.util.*;

public class Stack2Queues {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        // isEmpty
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // push
        public void push(int data) {
            q2.add(data);

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        // pop
        public int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                System.exit(0);
            }

            return q1.remove();
        }

        // peek
        public int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                System.exit(0);
            }

            return q1.peek();
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
