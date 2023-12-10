package DynamicProgramming;

public class RodCutting {
    // Given a rod of length n inches and an array of prices that includes prices of
    // all pieces of size smaller than n.
    // Determine the maximum value obtainable by cutting up the rod and selling the pieces
    // length = 1 2 4 5 6 7 8
    // price  = 1 5 8 9 10 17 17 20
    // rodLength = 8

    // Recursive solution
    // Time complexity: O(2^n)
    // Space complexity: O(1)
    public static int rodCuttingRecursive(int price[], int rodLength) {
        if (rodLength <= 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rodLength; i++) {
            max = Math.max(max, price[i] + rodCuttingRecursive(price, rodLength - i - 1));
        }

        return max;
    }

    // Dynamic Programming solution
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public static int rodCuttingDP(int price[], int rodLength) {
        int dp[] = new int[rodLength + 1];
        dp[0] = 0;

        for (int i = 1; i <= rodLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }

        return dp[rodLength];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;

        System.out.println(rodCuttingRecursive(price, rodLength));
        System.out.println(rodCuttingDP(price, rodLength));
    }
}
