public class CircularLL {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void addToEmptyList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            size++;
        } else {
            System.out.println("List is not empty. Use 'addToFront' or 'addToEnd' instead.");
        }
    }

    public void addToFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void removeFromFront() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        if (size == 1) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
        }
        size--;
    }

    public void print() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLL circularLL = new CircularLL();

        // Test addToEmptyList
        circularLL.addToEmptyList(1);
        circularLL.print(); // Output: 1

        // Test addToFront
        circularLL.addToFront(0);
        circularLL.print(); // Output: 0 1

        // Test addToEnd
        circularLL.addToEnd(2);
        circularLL.print(); // Output: 0 1 2

        // Test removeFromFront
        circularLL.removeFromFront();
        circularLL.print(); // Output: 1 2
    }
}
