package DynamicProgramming.CoinChange;

public class Memoization {
    public static int coinChange(int coins[], int n, int sum, int dp[][]) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if (coins[n-1] <= sum) {
            dp[n][sum] = coinChange(coins, n, sum-coins[n-1], dp) + coinChange(coins, n-1, sum, dp);
        } else {
            dp[n][sum] = coinChange(coins, n-1, sum, dp);
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int sum = 5;

        int dp[][] = new int[coins.length+1][sum+1];
        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(coinChange(coins, coins.length, sum, dp));
    }
}
