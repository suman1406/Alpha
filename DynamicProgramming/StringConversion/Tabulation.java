package DynamicProgramming.StringConversion;

public class Tabulation {
    public static int stringConversionTabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String s1 = "sunday";
        String s2 = "saturday";

        System.out.println(stringConversionTabulation(s1, s2, s1.length(), s2.length()));
    }
}
