package DynamicProgramming.KnapsackProblems.UnboundedKnapsack;

public class Memoization {
    public static int unboundedKnapsack (int wt[], int val[], int W, int n, int dp[][]) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n-1] > W) {
            return dp[n][W] = unboundedKnapsack(wt, val, W, n-1, dp);
        }

        return dp[n][W] = Math.max((val[n-1] + unboundedKnapsack(wt, val, W-wt[n-1], n, dp)), unboundedKnapsack(wt, val, W, n-1, dp));
    }

    public static void main(String[] args) {
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(unboundedKnapsack(wt, val, W, n, dp));
    }
}
