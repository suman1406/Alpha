import java.util.*;

public class Tabulation {
    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, n));
    }

    static int MatrixChainOrder(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int count = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (count < dp[i][j])
                        dp[i][j] = count;
                }
            }
        }
        return dp[1][n - 1];
    }
}
