package DynamicProgramming.LongestSubSequence;

public class Memoization {
    public static int longestSubSequence(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            dp[n][m] = 1 + longestSubSequence(s1, s2, n-1, m-1, dp);
        } else {
            dp[n][m] = Math.max(longestSubSequence(s1, s2, n-1, m, dp), longestSubSequence(s1, s2, n, m-1, dp));
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(longestSubSequence(s1, s2, s1.length(), s2.length(), dp));
    }
}
