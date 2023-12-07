package Heaps;
import java.util.*;

public class Heap {
    static class Heaps {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) {
            arr.add(val);
            
            int x = arr.size() - 1;  // x is my child index
            int parent = (x-1)/2;

            while(x > 0 && arr.get(x) < arr.get(parent)) { // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
            }
        }

        // peek
        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int parent = i;
            int left = 2*parent + 1;
            int right = 2*parent + 2;

            while(left < arr.size() && right < arr.size()) {
                int min = Math.min(arr.get(left), arr.get(right));
                if(arr.get(parent) > min) {
                    if(min == arr.get(left)) {
                        int temp = arr.get(parent);
                        arr.set(parent, arr.get(left));
                        arr.set(left, temp);
                        parent = left;
                    } else {
                        int temp = arr.get(parent);
                        arr.set(parent, arr.get(right));
                        arr.set(right, temp);
                        parent = right;
                    }
                } else {
                    break;
                }
                left = 2*parent + 1;
                right = 2*parent + 2;
            }
        }

        // remove
        public int remove() {
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            arr.remove(arr.size()-1);

            heapify(0);

            return temp;
        }

        // Heap sort
        public void heapSort() {
            for(int i = arr.size()-1; i >= 0; i--) {
                int temp = arr.get(0);
                arr.set(0, arr.get(i));
                arr.set(i, temp);

                heapify(0);
            }
        }

        // print
        public void print() {
            for(int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }

        // Nearby Cars problem
        public static void nearbyCars(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < k; i++) {
                pq.add(arr[i]);
            }

            for(int i = k; i < arr.length; i++) {
                System.out.print(pq.peek() + " ");
                pq.remove(arr[i-k]);
                pq.add(arr[i]);
            }

            System.out.println(pq.peek());
        }

        // Connect N ropes with min cost
        public static int connectNRopes(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            int cost = 0;
            while(pq.size() > 1) {
                int x = pq.remove();
                int y = pq.remove();
                cost += x + y;
                pq.add(x+y);
            }

            return cost;
        }

        // Weakest Soilder problem
        public static int weakestSoilder(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            int count = 0;
            while(pq.size() > 0) {
                int x = pq.remove();
                if(x <= k) {
                    count++;
                } else {
                    break;
                }
            }

            return count;
        }

        // Sliding Window Maximun
        public static void slidingWindowMax(int[] arr, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i = 0; i < k; i++) {
                pq.add(arr[i]);
            }

            for(int i = k; i < arr.length; i++) {
                System.out.print(pq.peek() + " ");
                pq.remove(arr[i-k]);
                pq.add(arr[i]);
            }

            System.out.println(pq.peek());
        }

        // Find minimum element in array using priority queue
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

        // Find minimum element in array using priority queue
        public Integer findMinimumElementInArrayUsingPriorityQueue(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }

            return pq.peek();
        }

        // get size
        public int getSize() {
            return arr.size();
        }

        public static void main(String[] args) {

            Heaps h = new Heaps();
            h.add(10);
            h.add(20);
            h.add(15);
            h.add(5);
            h.add(30);

            h.print();
            System.out.println("Heap Size: "+h.getSize());
            System.out.println("\n\n");
            System.out.println(h.findMinimumElementInArrayUsingPriorityQueue().toString());

        
            int[] arr = {10, 20, 15, 5, 30, 25, 35, 40, 45, 50, 55};
            int k = 3;
            nearbyCars(arr, k);

            int[] arr2 = {4, 3, 2, 6};
            System.out.println(connectNRopes(arr2));

            int[] arr3 = {1, 2, 3, 4, 5};
            System.out.println(weakestSoilder(arr3, 3));

            int[] arr4 = {10, 20, 15, 5, 30, 25, 35, 40, 45, 50, 55};
            slidingWindowMax(arr4, 3);
        }
    }
}
