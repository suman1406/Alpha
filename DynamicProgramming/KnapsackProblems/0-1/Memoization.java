public class Memoization {
    public static int knapsack (int weights[], int values[], int capacity, int n, int dp[][]) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        if (weights[n-1] > capacity) {
            return dp[n][capacity] = knapsack(weights, values, capacity, n-1, dp);
        }

        return dp[n][capacity] = Math.max(values[n-1] + knapsack(weights, values, capacity-weights[n-1], n-1, dp), knapsack(weights, values, capacity, n-1, dp));
    }

    public static void main(String[] args) {
        int weights[] = {10, 20, 30};
        int values[] = {60, 100, 120};
        int capacity = 50;
        int n = weights.length;
        int dp[][] = new int[n+1][capacity+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<capacity+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(weights, values, capacity, n, dp));
    }
}
