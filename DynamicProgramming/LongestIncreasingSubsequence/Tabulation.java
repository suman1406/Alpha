package DynamicProgramming.LongestIncreasingSubsequence;

public class Tabulation {
    public static int longestIncreasingSubsequence(int arr[], int n) {
        int dp[] = new int[n];
        dp[0] = 1;

        int result = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;

        System.out.println(longestIncreasingSubsequence(arr, n));
    }
}
