package DynamicProgramming.LongestIncreasingSubsequence;

public class Memoization {
    public static int longestIncreasingSubsequence(int arr[], int n, int dp[]) {
        if (dp[n] != -1) {
            return dp[n];
        }

        int res, max = 1;

        for (int i = 1; i < n; i++) {
            res = longestIncreasingSubsequence(arr, i, dp);

            if (arr[i-1] < arr[n-1] && res + 1 > max) {
                max = res + 1;
            }
        }

        dp[n] = max;
        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;

        int dp[] = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = -1;
        }

        System.out.println(longestIncreasingSubsequence(arr, n, dp));
    }
}
