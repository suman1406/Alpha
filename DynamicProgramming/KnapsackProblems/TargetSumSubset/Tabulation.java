package DynamicProgramming.KnapsackProblems.TargetSumSubset;

public class Tabulation {
    public static boolean targetSumSubset (int arr[], int sum, int n, boolean dp[][]) {
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<sum+1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<sum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = (dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 7};
        int sum = 10;
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        System.out.println(targetSumSubset(arr, sum, n, dp));
    }
}
