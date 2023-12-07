package Heaps;
import java.util.*;

public class PriorityQueues {
    static class Student implements Comparable<Student> {
        int rank;
        String name;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // CompareTo method
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(5);
        pq.add(30);
        pq.add(25);
        pq.add(35);
        pq.add(40);
        pq.add(45);
        pq.add(50);
        pq.add(55);

        System.out.println(pq.peek());

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

        System.out.println();

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

        pq2.add(10);
        pq2.add(20);
        pq2.add(15);
        pq2.add(5);

        while (!pq2.isEmpty()) {
            System.out.print(pq2.poll() + " ");
        }

        System.out.println();

        PriorityQueue<Student> pq3 = new PriorityQueue<Student>();
        pq3.add(new Student("A", 10));
        pq3.add(new Student("B", 20));
        pq3.add(new Student("C", 15));
        pq3.add(new Student("D", 5));

        while (!pq3.isEmpty()) {
            Student s = pq3.poll();
            System.out.println(s.name + " " + s.rank);
        }

        System.out.println();
    }
}
