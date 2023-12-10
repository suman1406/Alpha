package DynamicProgramming.CoinChange;

public class Recursion {
    public static int coinChange(int coins[], int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        if (coins[n-1] <= sum) {
            return coinChange(coins, n, sum-coins[n-1]) + coinChange(coins, n-1, sum);
        } else {
            return coinChange(coins, n-1, sum);
        }
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3};
        int sum = 5;

        System.out.println(coinChange(coins, coins.length, sum));
    }
}
