package DynamicProgramming.StringConversion;

public class Memoization {
    public static int stringConversionMemoization(String s1, String s2, int n, int m, int dp[][]) {
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
            return dp[n][m] = stringConversionMemoization(s1, s2, n-1, m-1, dp);
        }

        return dp[n][m] = 1 + Math.min(stringConversionMemoization(s1, s2, n-1, m-1, dp), Math.min(stringConversionMemoization(s1, s2, n-1, m, dp), stringConversionMemoization(s1, s2, n, m-1, dp)));
    }

    public static void main(String args[]) {
        String s1 = "sunday";
        String s2 = "saturday";

        int dp[][] = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(stringConversionMemoization(s1, s2, s1.length(), s2.length(), dp));
    }
}
