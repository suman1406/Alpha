package Heaps;

import java.util.*;

public class Heap {
    static class Heaps {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) {
            arr.add(val);

            int x = arr.size() - 1;
            int parent;

            while (x > 0) {
                parent = (x - 1) / 2;

                if (arr.get(x) < arr.get(parent)) {
                    // Swap elements if the child is smaller than the parent
                    int temp = arr.get(x);
                    arr.set(x, arr.get(parent));
                    arr.set(parent, temp);

                    // Move up to the parent
                    x = parent;
                } else {
                    break; // Break the loop if the heap property is satisfied
                }
            }
        }

        public int peek() {
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }
            return arr.get(0);
        }

        private void heapify(int i) {
            int parent = i;
            int left, right, minChild;

            while (true) {
                left = 2 * parent + 1;
                right = 2 * parent + 2;
                minChild = parent;

                // Find the index of the smallest child
                if (left < arr.size() && arr.get(left) < arr.get(minChild)) {
                    minChild = left;
                }
                if (right < arr.size() && arr.get(right) < arr.get(minChild)) {
                    minChild = right;
                }

                // Swap with the smallest child if needed
                if (minChild != parent) {
                    int temp = arr.get(parent);
                    arr.set(parent, arr.get(minChild));
                    arr.set(minChild, temp);
                    parent = minChild;
                } else {
                    break; // Break the loop if the heap property is satisfied
                }
            }
        }

        public int remove() {
            if (arr.isEmpty()) {
                throw new NoSuchElementException("Heap is empty");
            }

            int removedValue = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);

            heapify(0);

            return removedValue;
        }

        public void heapSort() {
            int n = arr.size();

            // Build heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(i);
            }

            // Extract elements one by one
            for (int i = n - 1; i > 0; i--) {
                int temp = arr.get(0);
                arr.set(0, arr.get(i));
                arr.set(i, temp);

                heapify(0);
            }
        }

        public void print() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }

        public static void nearbyCars(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                pq.add(arr[i]);
            }

            for (int i = k; i < arr.length; i++) {
                System.out.print(pq.peek() + " ");
                pq.remove(arr[i - k]);
                pq.add(arr[i]);
            }

            System.out.println(pq.peek());
        }

        public static int connectNRopes(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            int cost = 0;
            while (pq.size() > 1) {
                int x = pq.remove();
                int y = pq.remove();
                cost += x + y;
                pq.add(x + y);
            }

            return cost;
        }

        public static int weakestSoilder(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            int count = 0;
            while (!pq.isEmpty()) {
                int x = pq.remove();
                if (x <= k) {
                    count++;
                } else {
                    break;
                }
            }

            return count;
        }

        public static void slidingWindowMax(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                pq.add(arr[i]);
            }

            for (int i = k; i < arr.length; i++) {
                System.out.print(pq.peek() + " ");
                pq.remove(arr[i - k]);
                pq.add(arr[i]);
            }

            System.out.println(pq.peek());
        }

        public Integer findMinimumElementInArrayUsingPriorityQueue() {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
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

            return pq.peek();
        }

        public Integer findMinimumElementInArrayUsingPriorityQueue(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            return pq.peek();
        }

        public int getSize() {
            return arr.size();
        }

        
    }

    public static void main(String[] args) {
            Heaps h = new Heaps();
            h.add(10);
            h.add(20);
            h.add(15);
            h.add(5);
            h.add(30);

            h.print();
            System.out.println("Heap Size: " + h.getSize());
            System.out.println("\n\n");
            System.out.println(h.findMinimumElementInArrayUsingPriorityQueue().toString());

            int[] arr = { 10, 20, 15, 5, 30, 25, 35, 40, 45, 50, 55 };
            int k = 3;
            Heaps.nearbyCars(arr, k);

            int[] arr2 = { 4, 3, 2, 6 };
            System.out.println(Heaps.connectNRopes(arr2));

            int[] arr3 = { 1, 2, 3, 4, 5 };
            System.out.println(Heaps.weakestSoilder(arr3, 3));

            int[] arr4 = { 10, 20, 15, 5, 30, 25, 35, 40, 45, 50, 55 };
            Heaps.slidingWindowMax(arr4, 3);
        }
}
