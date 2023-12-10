package DynamicProgramming;

public class EditDistance {
    // Recursion
    public static int editDistanceRecursion(String s1, String s2, int n, int m) {
        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return editDistanceRecursion(s1, s2, n-1, m-1);
        }

        return 1 + Math.min(editDistanceRecursion(s1, s2, n-1, m-1), Math.min(editDistanceRecursion(s1, s2, n-1, m), editDistanceRecursion(s1, s2, n, m-1)));
    }

    // Memoization
    public static int editDistanceMemoization(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return editDistanceMemoization(s1, s2, n-1, m-1, dp);
        }

        dp[n][m] = 1 + Math.min(editDistanceMemoization(s1, s2, n-1, m-1, dp), Math.min(editDistanceMemoization(s1, s2, n-1, m, dp), editDistanceMemoization(s1, s2, n, m-1, dp)));
        return dp[n][m];
    }

    // Tabulation
    public static int editDistanceTabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];

                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }

            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(editDistanceRecursion(s1, s2, s1.length(), s2.length()));

        System.out.println(editDistanceMemoization(s1, s2, s1.length(), s2.length(), dp));

        System.out.println(editDistanceTabulation(s1, s2, s1.length(), s2.length()));

    }
}
