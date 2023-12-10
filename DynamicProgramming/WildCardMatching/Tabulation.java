package DynamicProgramming.WildCardMatching;

public class Tabulation {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Base case
        dp[s.length()][p.length()] = true;
        for (int j = p.length() - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                dp[s.length()][j] = true;
            } else {
                break;
            }
        }

        // Induction rule
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Tabulation tabulation = new Tabulation();
        System.out.println(tabulation.isMatch("aa", "a"));
        System.out.println(tabulation.isMatch("aa", "*"));
        System.out.println(tabulation.isMatch("cb", "?a"));
        System.out.println(tabulation.isMatch("adceb", "*a*b"));
        System.out.println(tabulation.isMatch("acdcb", "a*c?b"));
    }
}
