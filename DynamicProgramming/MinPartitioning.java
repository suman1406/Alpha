package DynamicProgramming;

public class MinPartitioning {
    // minimum partitioning
    static int minPartition(int[] arr, int n) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2, 2, 1 };
        int n = arr.length;
        System.out.println("The minimum difference between 2 sets is " + minPartition(arr, n));
    }
}
