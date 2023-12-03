package Queue;

public class QueueB {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = 0;
            rear = -1;
        }

        public static boolean isEmpty() {
            return size == -1;
        }

        //isfull
        public static boolean isFull() {
            return rear == size-1;
        }

        // add
        public void add(int data) {
            if(rear == size-1) {
                System.out.println("queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            return arr[0];
        }

    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
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
