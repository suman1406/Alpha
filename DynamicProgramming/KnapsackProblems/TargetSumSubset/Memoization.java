package DynamicProgramming.KnapsackProblems.TargetSumSubset;

public class Memoization {
    public static boolean targetSumSubset (int arr[], int sum, int n, boolean dp[][]) {
        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (dp[n][sum] != false) {
            return dp[n][sum];
        }

        if (arr[n-1] > sum) {
            return dp[n][sum] = targetSumSubset(arr, sum, n-1, dp);
        }

        return dp[n][sum] = targetSumSubset(arr, sum-arr[n-1], n-1, dp) || targetSumSubset(arr, sum, n-1, dp);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 7};
        int sum = 10;
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<sum+1; j++) {
                dp[i][j] = false;
            }
        }
        System.out.println(targetSumSubset(arr, sum, n, dp));
    }
}
