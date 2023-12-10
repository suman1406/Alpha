public class Tabulation {
    public static int knapsack (int weights[], int values[], int capacity, int n) {
        int dp[][] = new int[n+1][capacity+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<capacity+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (weights[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int weights[] = {10, 20, 30};
        int values[] = {60, 100, 120};
        int capacity = 50;
        int n = weights.length;
        System.out.println(knapsack(weights, values, capacity, n));
    }
}
