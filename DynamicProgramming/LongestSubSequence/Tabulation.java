package DynamicProgramming.LongestSubSequence;

public class Tabulation {
    public static int longestSubSequence(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < m+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            } 
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        System.out.println(longestSubSequence(s1, s2, s1.length(), s2.length()));
    }
}
