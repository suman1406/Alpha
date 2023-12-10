package DynamicProgramming.LongestCommonSubstring;

public class Memoization {
    public static int longestCommonSubstring(String s1, String s2, int n, int m, int count, int dp[][]) {
        if (n == 0 || m == 0) {
            return count;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            count = longestCommonSubstring(s1, s2, n-1, m-1, count+1, dp);
        } else {
            // If characters are not equal, reset count to 0
            count = 0;
        }

        // Compare the current count with the counts from recursive calls
        count = Math.max(count, Math.max(longestCommonSubstring(s1, s2, n-1, m, 0, dp),
                                          longestCommonSubstring(s1, s2, n, m-1, 0, dp)));

        dp[n][m] = count;
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

        System.out.println(longestCommonSubstring(s1, s2, s1.length(), s2.length(), 0, dp));
    }
}
