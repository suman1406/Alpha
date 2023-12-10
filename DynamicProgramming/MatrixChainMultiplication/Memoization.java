import java.util.*;

public class Memoization {
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
    }

    static int MatrixChainOrder(int[] arr, int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (count < min)
                min = count;
        }
        return dp[i][j] = min;
    }
}
