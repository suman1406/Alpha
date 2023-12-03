package Queue;
import java.util.*;

public class DeQueue {

    static class MyStack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int x) {
            deque.addFirst(x);
        }

        public void pop() {
            deque.removeFirst();
        }

        public int top() {
            return deque.peekFirst();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        //peek
        public int peek() {
            return deque.getLast();
        }

    }

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void enqueue(int x) {
            deque.addLast(x);
        }

        public void dequeue() {
            deque.removeFirst();
        }

        public int front() {
            return deque.peekFirst();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public int size() {
            return deque.size();
        }
    }


    public static void main(String args[]) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front of the queue: " + queue.front());
        System.out.println("Queue size: " + queue.size());

        queue.dequeue();

        System.out.println("Front of the queue after dequeue: " + queue.front());
        System.out.println("Queue size after dequeue: " + queue.size());
    }
}
