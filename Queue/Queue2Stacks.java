package Queue;
import java.util.*;

public class Queue2Stacks {
    static class Queue {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        
        // isEmpty
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        //add
        public void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public int remove() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }

            int x = s1.peek();
            s1.pop();
            return x;
        }

        // peek
        public int peek() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                System.exit(0);
            }

            return s1.peek();
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
