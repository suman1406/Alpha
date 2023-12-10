public class Recursion {
    public static int knapsack (int weights[], int values[], int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (weights[n-1] > capacity) {
            return knapsack(weights, values, capacity, n-1);
        }

        return Math.max(values[n-1] + knapsack(weights, values, capacity-weights[n-1], n-1), knapsack(weights, values, capacity, n-1));
    }

    public static void main(String[] args) {
        int weights[] = {10, 20, 30};
        int values[] = {60, 100, 120};
        int capacity = 50;
        int n = weights.length;
        System.out.println(knapsack(weights, values, capacity, n));
    }
}
