package Queue;

public class QueueLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null & tail == null;
        }

        //add
        public void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            int result = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return result;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return head.data;
        }

    }


    public static void main(String args[]) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
