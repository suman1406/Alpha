package DynamicProgramming;

public class CountBSTs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of BSTs with " + n + " nodes are: " + countBSTs(n));

        System.out.println("Number of BSTs with " + n + " nodes are: " + countBSTsRecursive(n));

        System.out.println("Number of BSTs with " + n + " nodes are: " + countBSTsMemoized(n));

        System.out.println("Number of BSTs with " + n + " nodes are: " + countBSTsRecursiveWithDP(n));

    }

    private static int countBSTs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    private static int countBSTsRecursive(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            count += countBSTsRecursive(i) * countBSTsRecursive(n - i - 1);
        }

        return count;
    }

    private static int countBSTsMemoized(int n) {
        int[] dp = new int[n + 1];
        return countBSTsMemoizedHelper(n, dp);
    }

    private static int countBSTsMemoizedHelper(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            count += countBSTsMemoizedHelper(i, dp) * countBSTsMemoizedHelper(n - i - 1, dp);
        }

        return dp[n] = count;
    }

    private static int countBSTsRecursiveWithDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        return countBSTsRecursiveWithDPHelper(n, dp);
    }

    private static int countBSTsRecursiveWithDPHelper(int n, int[] dp) {
        if(dp[n] != 0) {
            return dp[n];
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            count += countBSTsRecursiveWithDPHelper(i, dp) * countBSTsRecursiveWithDPHelper(n - i - 1, dp);
        }

        return dp[n] = count;
    }
}
