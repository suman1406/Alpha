package DynamicProgramming.KnapsackProblems.UnboundedKnapsack;

public class Tabulation {
    public static int unboundedKnapsack (int wt[], int val[], int W, int n, int dp[][]) {
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<W+1; j++) {
                if (wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max((val[i-1] + dp[i][j-wt[i-1]]), dp[i-1][j]);
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];
        System.out.println(unboundedKnapsack(wt, val, W, n, dp));
    }
}
